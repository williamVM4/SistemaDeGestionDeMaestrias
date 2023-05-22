<div id="perfil-documento-personal">
    <div class="subtitulo-Perfil"><h3>Documentos Personales
            <span title="Editar datos" onclick="" class="text-info puntero pull-right">
                <i class="fa bi-pencil-square"></i>
            </span>
        </h3>
    </div>

    <table style="width:100%; " class="table table-bordered table-striped small">
        <tbody>
            <tr>
                <td width="50%">DUI</td>
                <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirDui"><i class="bi bi-upload"></i></a>
                  <c:if test="${not empty documentos}">
                      <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                      <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                  </c:if>
                </td>
            </tr>
            <tr>
                <td>NIT</td>
                <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirNit"><i class="bi bi-upload"></i></a>
                  <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                  <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                </td>            </tr>
            <tr>
                <td>NUP</td>
                <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirNup"><i class="bi bi-upload"></i></a>
                  <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                  <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                </td>            </tr>
            <tr>
                <td>CURRICULUM</td>
                <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirCV"><i class="bi bi-upload"></i></a>
                  <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                  <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                </td>            </tr>
            <tr>
                <td>PASAPORTE</td>
                 <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirPasaporte"><i class="bi bi-upload"></i></a>
                  <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                  <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                </td>            </tr>
            <tr>
                <td>DOCUMENTO DE IDENTIFICACION EXTRANJERO</td>
                <td>
                  <a type="button" class="btn btn-outline-primary" href="" data-bs-toggle="modal" data-bs-target="#subirDocExtranjero"><i class="bi bi-upload"></i></a>
                  <a type="button" class="btn btn-outline-secondary" href=""><i class="bi bi-eye"></i></a>
                  <a type="button" class="btn btn-outline-danger" href=""><i class="bi bi-trash"></i></a>
                </td>            </tr>
        </tbody>
    </table>
                        <!--<a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#confirmarEliminar-${elemento.idCoorAca}">
                            <i class="bi bi-trash"></i>
                        </a>
                        Modal de confirmaci�n de eliminaci�n
                        <div class="modal fade" id="confirmarEliminar-${elemento.idCoorAca}" tabindex="-1" aria-labelledby="confirmarEliminarLabel-${elemento.idCoorAca}" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="confirmarEliminarLabel-${elemento.idCoorAca}">Confirmar eliminaci�n</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p><strong>�Est�s seguro de eliminar este aspirante?</strong></p>
                                        <p>Ten en cuenta que se eliminar�n todos los datos relacionados a ${elemento.nombresCa} ${elemento.apellidosCa}.</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        <a href="/eliminarCoordinadorAcademico/${elemento.idCoorAca}" class="btn btn-danger">Eliminar</a>
                                    </div>
                                </div>
                            </div>
                        </div>-->



    <!-- Modal para agregar dui -->
    <div class="modal fade" id="subirDui" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir DUI</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="DUI">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="docFile" name="docFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal para agregar nit -->
    <div class="modal fade" id="subirNit" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir NIT</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="NIT">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="nitFile" name="nitFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal para agregar nup -->
    <div class="modal fade" id="subirNup" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir NUP</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="NUP">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="nupFile" name="nupFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal para agregar cv -->
    <div class="modal fade" id="subirCV" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir curr�culum</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="CURRICULUM">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="cvFile" name="cvFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal para agregar pasaporte -->
    <div class="modal fade" id="subirPasaporte" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir pasaporte</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="PASAPORTE">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="pasaporteFile" name="pasaporteFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal para agregar DocExtranjero -->
    <div class="modal fade" id="subirDocExtranjero" tabindex="-1" aria-labelledby="crearModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="crearModalLabel">Subir documento de identificaci�n extranjero</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="row align-items-start">
                <div class="col">
                    <form action="/actualizarDocumento/${coordinadorCA.idCoorAca}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <input type="hidden" name="tipoDocumento" value="DOCUMENTO-EXTRANJERO">
                      <div class="input-group mb-3">
                        <input type="file" class="form-control" id="docPersonalFile" name="docPersonalFile" aria-hidden="true" accept=".pdf" required>
                      </div>              
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-outline-success">Subir</button>
                        <button type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                      </div>
                    </form>
                </div>
                <div class="row text-justify">
                  <p>Para que el documento sea incorporado en su expediente, tome en cuenta los siguientes detalles del archivo:</p>
                  <ul style="padding-left: 40px;">
                    <li>Tipo de archivo PDF (*.pdf)</li>
                    <li>El tama�o m�ximo permitido para subir es 500MB.</li>
                    <li>El nombre del archivo no debe contener espacios, ni tildes.</li>
                    <li>Subir documentos ajenos ser� considerado como una falta.</li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>




</div>
                