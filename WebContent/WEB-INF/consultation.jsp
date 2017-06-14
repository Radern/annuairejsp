<%@ include file="../header.jsp"%>
<script language="javascript" src="javas.js" type="text/javascript"></script>
<!-- col-sm-8 -->
<div class="col-sm-8">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Liste des inscrits</h3>
        </div>
        <div class="panel-body">
            &nbsp;
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><a href="#"
                            onclick="sortTable(this,1); return false;">&nbsp;Nom&nbsp;</a></th>
                        <th><a href="#"
                            onclick="sortTable(this,2); return false;">&nbsp;Prénom&nbsp;</a></th>
                        <th>téléphone</th>
                        <th><a href="#"
                            onclick="sortTable(this,3); return false;">&nbsp;Ville&nbsp;</a></th>
                        <th>&nbsp;Modifier&nbsp;</th>
                        <th>&nbsp;Visualiser&nbsp;</th>
                        <th>&nbsp;Effacer&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ personnes }" var="ligne"
                        varStatus="status">
                        <tr>
                            <td>&nbsp;<c:out
                                value="${ ligne.getNom() }" />&nbsp;</td>
                            <td>&nbsp;<c:out
                                value="${ ligne.getPrenom() }" />&nbsp;</td>
                            <td>&nbsp;<c:out
                                value="${ ligne.getTelephone().getNumero() }" />&nbsp;</td>
                            <td>&nbsp;<c:out
                                value="${ ligne.getAdresse().getVille() }" />&nbsp;</td>
                            <td>&nbsp;<a
                                href="formulaires?action=Modifier&amp;fiche=<c:out
                                value="${ ligne.getId() }" />">&nbsp;<img
                                    src="images/icones/modif3.gif"
                                    alt="Modifier" /></a>&nbsp;
                            </td>
                            <td><a href="visualiser?fiche=<c:out
                                value="${ ligne.getId() }" />">&nbsp;<img
                                    src="images/icones/vue.gif"
                                    alt="Visualiser" /></a>&nbsp;</td>
                            <td><a
                                href="consultation?action=Effacer&amp;fiche=<c:out
                                value="${ ligne.getId() }" />"
                                onclick="return confirm('Supprimer cette fiche ?');">&nbsp;<img
                                    src="images/icones/efface.gif"
                                    alt="BBBB" /></a>&nbsp;</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            &nbsp;
        </div>
    </div>
</div>
<!-- /.col-sm-8 -->


<%@ include file="../footer.jsp"%>