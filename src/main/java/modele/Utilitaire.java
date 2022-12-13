/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Query;

/**
 *
 * @author Jon
 */
public class Utilitaire {

    public static String buildUrl(String baseQueryString, String itemCategory, String itemName) {
        String returnQuery = "";
        boolean categoryInFilter = baseQueryString.contains(itemCategory);
        boolean itemInFilter = baseQueryString.contains(itemName);
        // split the query on &
        ArrayList<String> filterList = new ArrayList<>(Arrays.asList(baseQueryString.split("&")));
        removeBlankFields(filterList);
        // length / 2 is number of filters
        int filterCount = filterList.size() / 2;
        if (!categoryInFilter) {
            // if Category in none of the filters, add filter.
            filterList.add("filter" + (filterCount + 1) + "n=" + itemCategory);
            filterList.add("filter" + (filterCount + 1) + "v=" + itemName);
        } else {
            // find filter #
            int filterNum = findFilterNumber(filterList, itemCategory);
            if (!itemInFilter) {
                // if Category in filter but not item, add item
                // find filter#n
                for (String filter : filterList) {
                    if (filter.matches("filter" + filterNum + "v.+")) {
                        List<String> tmpItemList = new ArrayList<>(Arrays.asList(filter.substring(9).split(",")));
                        tmpItemList.add(itemName);
                        filterList.remove(filter);
                        filterList.add(filter.replaceAll("=.*", "=" + String.join(",", tmpItemList)));
                        break;
                    }
                }
            } else {
                boolean categoryEmpty = false;
                // if Category and item in filter, remove item
                for (String filter : filterList) {
                    if (filter.matches("filter" + filterNum + "v=.+")) {
                        List<String> tmpItemList = new ArrayList<>(Arrays.asList(filter.substring(9).split(",")));
                        tmpItemList.remove(itemName);
                        filterList.remove(filter);
                        filterList.add(filter.replaceAll("=.*", "=" + String.join(",", tmpItemList)));
                        categoryEmpty = tmpItemList.isEmpty();
                        break;
                    }
                }
                // if Category has no other items, remove Category
                if (categoryEmpty) {
                    Iterator<String> itt = filterList.iterator();
                    while (itt.hasNext()) {
                        String filter = itt.next();
                        if (filter.matches("filter" + filterNum + ".+")) {
                            itt.remove();
                        }
                    }
                }
            }
        }
        Collections.sort(filterList);
        List<String> formattedList = new ArrayList<>();

        for (int i = 0; i < filterList.size(); i++) {
            formattedList.add(
                    filterList.get(i).replaceFirst("(\\d+)", String.valueOf((i / 2) + 1))
            );
        }

        // rebuild query
        if (!filterList.isEmpty()) {
            returnQuery = String.join("&", formattedList);
        }
        return returnQuery;
    }

    private static int findFilterNumber(List<String> filterList, String itemCategory) {
        int filterNum = 0;
        for (String s : filterList) {
            if (s.matches("filter(\\d+)n=" + itemCategory)) {
                filterNum = Integer.valueOf(Character.toString(s.charAt(6)));
            }
        }
        return filterNum;
    }

    private static void removeBlankFields(List<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String s = i.next();
            if (s.isBlank()) {
                i.remove();
            }
        }
    }

    public static String getQueryFromUrl(String url) {
        // split on & to get fitler#n and filter#v and change to list
        String baseQuery = "SELECT * FROM PRODUCT";
        if (url.isBlank()) {
            return baseQuery;
        }
        ArrayList<String> filterList = new ArrayList<>(Arrays.asList(url.split("&")));

        List<String> queryBits = new ArrayList<>();
        StringBuilder resultQuery = new StringBuilder();

        for (String findCategories : filterList) {
            if (findCategories.matches("filter(\\d+)n.*")) {  // a filter#n was found
                String filterNum = Character.toString(findCategories.charAt(6));
                for (String findValues : filterList) {
                    if (findValues.matches("filter" + filterNum + "v.*")) {
                        String tmpQuery = getQueryFragmentForValues(findCategories.substring(findCategories.indexOf("=") + 1), findValues.substring(findValues.indexOf("=") + 1));
                        queryBits.add(tmpQuery);
                    }
                }
            }
        }
        resultQuery.append(baseQuery);
        if (!queryBits.isEmpty()) {
            resultQuery.append(" WHERE ");
            resultQuery.append(String.join(" AND ", queryBits));
        }
        return resultQuery.toString();
    }

    private static String getQueryFragmentForValues(String category, String values) {
        String queryBit = "";
        switch (category) {
            case "Companion":
                queryBit = "categorie in (" + prepValuesForQuery(values) + ")";
                break;
            case "Type":
                queryBit = "type in (" + prepValuesForQuery(values) + ")";
                break;
            case "Availability":
                int valueCount = (values.split(",")).length;
                // if valueCount == 2, wanted both available and not available. Encompasses everything.
                if (valueCount == 1) {
                    if (values.equals(Constantes.AVAILABILITY_NOT_AVAILABLE)) {
                        queryBit = "(quantity = 0 OR active = 0)";
                    } else {
                        queryBit = "quantity > 0 AND active = 1";
                    }
                }
                break;
            case "Price":
                // split the values on comma
                List<String> splitValues = new ArrayList<>(Arrays.asList(values.split(",")));
                List<String> formattedValues = new ArrayList<>();
                for (String tmpValue : splitValues) {
                    List<String> splitPrices = new ArrayList<>(Arrays.asList(tmpValue.split("-")));
                    String thisValue = "price between " + String.join(" AND ", splitPrices);
                    formattedValues.add(thisValue);
                }
                queryBit = "(" + String.join(" OR ", formattedValues) + ")";
                break;
        }
        return queryBit;
    }

    /**
     * Adds ' around the values to fit "in" sql statement. Only use for columns
     * that can be used with "in".
     *
     * @param values comma separated.
     * @return values comma separated but with ' around the words.
     */
    private static String prepValuesForQuery(String values) {
        String[] tmpOrigValues = values.split(",");
        String[] tmpConvertedValues = new String[tmpOrigValues.length];
        for (int i = 0; i < tmpOrigValues.length; i++) {
            tmpConvertedValues[i] = "'" + tmpOrigValues[i] + "'";
        }
        values = String.join(",", tmpConvertedValues);
        return values;
    }

    public static boolean isActiveFilter(String baseQueryUrl, String itemName){
        return baseQueryUrl.contains(itemName);
    }
    
    public static Set<ItemCategorie> sortPriceFilters(Set<ItemCategorie> unsortedFilters){
        TreeSet<ItemCategorie> tempSet = new TreeSet<>();
        
        if(unsortedFilters.isEmpty() || unsortedFilters.size() == 1)
            return unsortedFilters;
        
        for(int i = 1;i <= unsortedFilters.size();i++){
            
            for(ItemCategorie ic: unsortedFilters){
                if(getPriceRangeOrder(ic.getName()) == i){
                    tempSet.add(ic);
                }
            }
        }
        return tempSet;
    }
    
    private static int getPriceRangeOrder(String range){
        switch(range){
            case Constantes.PRICE_RANGE_0_1999:
                return 1;
            case Constantes.PRICE_RANGE_20_4999:
                return 2;
            case Constantes.PRICE_RANGE_50_9999:
                return 3;
            case Constantes.PRICE_RANGE_100_49999:
                return 4;
            default:
                return 0;
        }
    }
}
