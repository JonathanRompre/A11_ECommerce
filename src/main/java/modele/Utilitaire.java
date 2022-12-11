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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //String[] filterList = baseQueryString.split("&");
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
        // rebuild query
        if (!filterList.isEmpty()) {
            returnQuery = String.join("&", filterList);
        }
        return returnQuery;
    }

    public static int findFilterNumber(List<String> filterList, String itemCategory) {
        int filterNum = 0;
        for (String s : filterList) {
            if (s.matches("filter(\\d+)n=" + itemCategory)) {
                filterNum = Integer.valueOf(Character.toString(s.charAt(6)));
            }
        }
        return filterNum;
    }

    public static void removeBlankFields(List<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String s = i.next();
            if (s.isBlank()) {
                i.remove();
            }
        }
    }
}
