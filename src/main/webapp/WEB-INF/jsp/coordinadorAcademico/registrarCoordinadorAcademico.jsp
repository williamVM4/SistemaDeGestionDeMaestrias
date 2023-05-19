<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

  <form action="/guardar" method="POST" modelAttribute="coordinador" accept-charset="UTF-8">

    <label for="codCa">Carnet de identificación:</label>
    <input type="text" class="form-control" id="codCa" name="codCa" maxlength="6" required>

    <input type="submit" name="guardar" value="Guardar">

  </form>

<%@ include file="../common/footer.jspf"%>