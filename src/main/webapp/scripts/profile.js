/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function updateProfile(){
    
    cleanSlate();
    
    requete = new XMLHttpRequest();
    
    url = "ProfileUpdate";
    
    requete.onreadystatechange = traiterUpdateValidation;
    
    requete.open("POST", url, true);
    requete.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    urlParams = [];
    if($('#firstName').val() !== ''){
        urlParams[urlParams.length] = "firstName="+$('#firstName').val();
    }
    if($('#lastName').val() !== ''){
        urlParams[urlParams.length] = "lastName="+$('#lastName').val();
    }
    if($('#email').val() !== ''){
        urlParams[urlParams.length] = "email="+$('#email').val();
    }
    if(($('#currentPassword').val() !== '') && ($('#newPassword').val() != '')){
        urlParams[urlParams.length] = "currentPassword="+$('#currentPassword').val();
        urlParams[urlParams.length] = "newPassword="+$('#newPassword').val();
    }
    
    urlParamString = urlParams.join("&");
    requete.send(urlParamString);
}

function traiterUpdateValidation(){
    if((requete.readyState === 4) && (requete.status === 200)){
        bodyHtml = $(document.body).html();
        jsonResponse = JSON.parse(requete.responseText);
        auth = jsonResponse.authValid;
        pwChange = jsonResponse.pwChange;
        updateSuccess = jsonResponse.updateSuccess;
        
        if(!auth && pwChange){
            
            $('#saveProfile').removeClass("btn-outline-secondary").addClass("btn-outline-danger");
            // attempt to change pw but incorrect
            tmpContent = $('#profilePassword').html();
            warning = "<span class='text-danger px-3'>Error: Wrong password</span>";
            $('#profilePassword').html(warning+tmpContent);
            $('#profilePassword').children('div')[0].children[1].classList += ' border-danger';
        }else if(updateSuccess && (auth || !pwChange)){
            $('#saveProfile').removeClass("btn-outline-secondary").addClass("btn-success");
            $('#saveProfile').val('text')[0].textContent = "Saved";
            setTimeout(function(){
                $('#saveProfile').val('text')[0].textContent = "Save changes";
                $('#saveProfile').removeClass("btn-success").addClass("btn-outline-secondary");
            },5000);
        }else{
            $('#profile').addClass("border-danger");
            tmpContent = $('#profile').html();
            warning = "<span class='text-danger px-3'>An error occured. Changes were not saved. Please try again.</span>";
            $('#profilePassword').html(warning+tmpContent);
        }
    }
} 

function cleanSlate(){
    $('#profilePassword').children('span').remove();
    $('#profilePassword').children('div')[0].children[1].classList.value = $('#profilePassword').children('div')[0].children[1].classList.value.replace(' border-danger',''); 
    $('#profile').removeClass("border-danger");
    $('#profile').children('span').remove();
    $('#saveProfile').removeClass("btn-outline-danger").addClass("btn-outline-secondary");
}