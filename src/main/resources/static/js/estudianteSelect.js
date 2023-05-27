document.addEventListener("DOMContentLoaded", function() {
        //Manejo de mascaras
        var inputDocPersonal = document.getElementById('docPersonalE');
        var inputPasaporte = document.getElementById("pasaporteE");
        var inputDui = document.getElementById("duiE");
        var inputNit = document.getElementById("nitE");
        var inputNup = document.getElementById("nupE");
        var inputFechaNac = document.getElementById("fechaNacE");
        $(inputDocPersonal).inputmask('9999999999999999999999999999', {
            showMaskOnFocus: false,
            showMaskOnHover: false
        });
        $(inputPasaporte).inputmask('*********', {
            showMaskOnFocus: false,
            showMaskOnHover: false
        });
//        $(inputDui).inputmask('99999999-9', {
//            showMaskOnFocus: false,
//            showMaskOnHover: false
//        });
//        $(inputNit).inputmask('9999-999999-999-9', {
//            showMaskOnFocus: false,
//            showMaskOnHover: false
//        });
//        $(inputNup).inputmask('999999999999', {
//            showMaskOnFocus: false,
//            showMaskOnHover: false
//        });
        $(inputFechaNac).inputmask('99/99/9999', {
            showMaskOnFocus: false,
            showMaskOnHover: false
        });
    });
    
//    function validarParametros() {
//        var resultado = true;
//        var fechaNacimiento = document.getElementById('fechaNacE').value;
//        var fechaInput= document.getElementById('fechaNacE').value;
//        fechaInput=fechaInput.replace("_", "");
//        var duiInput= document.getElementById('duiE').value;
//        duiInput=duiInput.replace("_", "");
//        var nitInput= document.getElementById('nitE').value;
//        nitInput=nitInput.replace("_", "");
//        var nupInput= document.getElementById('nupE').value;
//        nupInput=nupInput.replace("_", "");
//        var partesFecha = fechaNacimiento.split("/"); // Suponiendo que el formato de fecha es "dd-mm-yyyy"
//        var dia = parseInt(partesFecha[0], 10);
//        var mes = parseInt(partesFecha[1], 10) - 1; // Restamos 1 al mes porque en JavaScript los meses van de 0 a 11
//        var anio = parseInt(partesFecha[2], 10);
//        var fechaConvertida=anio+"/"+mes+"/"+dia;
//        var fechaNacimientoOk = new Date(fechaConvertida);
//        var fechaActual = new Date();
//        var edadMilisegundos = fechaActual.getTime() - fechaNacimientoOk.getTime();
//        var edadAnios = Math.floor(edadMilisegundos / (1000 * 60 * 60 * 24 * 365));
//        if (edadAnios < 18) {
////            mensajeErrorFecha.classList.remove("d-none");
//            resultado = false; // Detener el envío del formulario
//        }
//        if (fechaInput.length > 0 && fechaInput.length < 10) {
////            mensajeErrorFechaNacimiento.classList.remove("d-none");
//            resultado = false; // Detener el envío del formulario
//        }
//        if (duiInput.length > 0 && duiInput.length < 10) {
////            mensajeErrorDui.classList.remove("d-none");
//            resultado = false; // Detener el envío del formulario
//        }
//        if (nitInput.length > 0 && nitInput.length < 17) {
////            mensajeErrorNit.classList.remove("d-none");
//            resultado = false; // Detener el envío del formulario
//        }
//        if (nupInput.length > 0 && nupInput.length < 12) {
////            mensajeErrorNup.classList.remove("d-none");
//            resultado = false; // Detener el envío del formulario
//        }
//        return resultado;
//    }
    
    
    function mostrarOcultarSelect() {
        var inputDocPersonal = document.getElementById('docPersonalE');
        var inputPasaporte = document.getElementById("pasaporteE");
        var inputDui = document.getElementById("duiE");
        var inputNit = document.getElementById("nitE");
        var inputNup = document.getElementById("nupE");
        var selectPais = document.getElementById("idPais");
        var docPersonal= document.getElementById("group-docPersonalE");
        var pasaporte = document.getElementById("group-pasaporteE");
        var dui = document.getElementById("group-duiE");
        var nit = document.getElementById("group-nitE");
        var nup = document.getElementById("group-nupE"); 

        if (selectPais.options[selectPais.selectedIndex].text === "Seleccione una opción"){
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
            inputDocPersonal.value="";
            inputPasaporte.value="";
            inputDui.value="";
            inputNit.value="";
            inputNup.value="";
            inputDocPersonal.required = false;
            inputPasaporte.required = false;
            inputDui.required = false;
            inputNit.required = false;
            inputNup.required = false;
        }else if (selectPais.options[selectPais.selectedIndex].text === "El Salvador") {
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.remove("d-none");
            nit.classList.remove("d-none");
            nup.classList.remove("d-none");
            inputDocPersonal.value="";
            inputPasaporte.value="";
            inputDocPersonal.required = false;
            inputPasaporte.required = false;
            inputDui.required = true;
            inputNit.required = true;
            inputNup.required = true;
        } else {
            docPersonal.classList.remove("d-none");
            pasaporte.classList.remove("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
            inputDui.value="";
            inputNit.value="";
            inputNup.value="";
            inputDui.required = false;
            inputNit.required = false;
            inputNup.required = false;
            inputDocPersonal.required = true;
            inputPasaporte.required = true;
        }
    }
    function cargarSelect() {
        var inputDocPersonal = document.getElementById('docPersonalE');
        var inputPasaporte = document.getElementById("pasaporteE");
        var inputDui = document.getElementById("duiE");
        var inputNit = document.getElementById("nitE");
        var inputNup = document.getElementById("nupE");
        var selectPais = document.getElementById("idPais");
        var docPersonal= document.getElementById("group-docPersonalE");
        var pasaporte = document.getElementById("group-pasaporteE");
        var dui = document.getElementById("group-duiE");
        var nit = document.getElementById("group-nitE");
        var nup = document.getElementById("group-nupE");

        if (selectPais.options[selectPais.selectedIndex].text === "Seleccione una opción"){
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
            inputDocPersonal.required = false;
            inputPasaporte.required = false;
            inputDui.required = false;
            inputNit.required = false;
            inputNup.required = false;
        }else if (selectPais.options[selectPais.selectedIndex].text === "El Salvador") {
            docPersonal.classList.add("d-none");
            pasaporte.classList.add("d-none");
            dui.classList.remove("d-none");
            nit.classList.remove("d-none");
            nup.classList.remove("d-none");
            inputDocPersonal.required = false;
            inputPasaporte.required = false;
            inputDui.required = true;
            inputNit.required = true;
            inputNup.required = true;
        } else {
            docPersonal.classList.remove("d-none");
            pasaporte.classList.remove("d-none");
            dui.classList.add("d-none");
            nit.classList.add("d-none");
            nup.classList.add("d-none");
            inputDui.required = false;
            inputNit.required = false;
            inputNup.required = false;
            inputDocPersonal.required = true;
            inputPasaporte.required = true;
        }
    }