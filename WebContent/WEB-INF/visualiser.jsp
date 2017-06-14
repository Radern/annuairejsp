<%@ include file="../header.jsp"%>
<script language="javascript" src="javas.js" type="text/javascript"></script>
<div id="page1" style="DISPLAY: block;">
    <div class="page-header">
        <img src="images/flecheb.gif" alt="" /><b>Fiche</b>&nbsp;&nbsp;-&nbsp;&nbsp;<a
            onclick="echange_window(document.getElementById('page2'),document.getElementById('page1')); return false;"
            href="#">Adresse</a>
    </div>
    <!-- col-sm-6 -->
    <div class="col-sm-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Fiche</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <td>Nom</td>
                            <td><c:out
                                    value="${ personne.getNom() }" /></td>
                        </tr>
                        <tr>
                            <td>Prénom</td>
                            <td><c:out
                                    value="${ personne.getPrenom() }" /></td>
                        </tr>
                        <tr>
                            <td>Numéro</td>
                            <td><c:out
                                    value="${ personne.getTelephone().getNumero() }" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- /.col-sm-6 -->
</div>
<div id="page2" style="DISPLAY: none;">
    <div class="page-header">
        <a
            onclick="echange_window(document.getElementById('page1'),document.getElementById('page2')); return false;"
            href="#">Fiche</a>&nbsp;<img src="images/flecheb.gif" alt="" />&nbsp;&nbsp;-&nbsp;&nbsp;<b>Adresse</b>
    </div>
    <!-- col-sm-6 -->
    <div class="col-sm-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Adresse</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <td>Rue1</td>
                            <td><c:out
                                    value="${ personne.getAdresse().getRue1() }" /></td>
                        </tr>
                        <tr>
                            <td>Rue2</td>
                            <td><c:out
                                    value="${ personne.getAdresse().getRue2() }" /></td>
                        </tr>
                        <tr>
                            <td>Ville</td>
                            <td><c:out
                                    value="${ personne.getAdresse().getVille() }" /></td>
                        </tr>
                        <tr>
                            <td>Code postal</td>
                            <td><c:out
                                    value="${ personne.getAdresse().getCodePostal() }" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- /.col-sm-6 -->
</div>
<%@ include file="../footer.jsp"%>