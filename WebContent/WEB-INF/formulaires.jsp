<%@ include file="../header.jsp"%>
<c:if test="${ !empty message }">
    <c:out value="${ message }" />
</c:if>
<c:if test="${ empty message }">
    <!-- col-sm-4 -->
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Nouvelle fiche</h3>
            </div>
            <div class="panel-body">
                <form class="form-signin"
                    action="formulaires?action=Ajouter" method="post">
                    <fieldset class="form-group">
                        <label for="nom0">Nom</label> <input id="nom0"
                            class="form-control" required autofocus
                            placeholder="nom" type="text"
                            value="<c:out
                                    value="${ personne.getNom() }" />"
                            size="18" name="nom" maxlength="50" /> <label
                            for="prenom0">Prénom</label> <input
                            id="prenom0" class="form-control" required
                            autofocus placeholder="prénom" type="text"
                            value="<c:out
                                    value="${ personne.getPrenom() }" />"
                            size="18" name="prenom" maxlength="50" />
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="numero0">Numéro</label> <input
                            id="numero0" class="form-control" required
                            autofocus placeholder="numéro" type="tel"
                            value="<c:out
                                    value="${ personne.getTelephone().getNumero() }" />"
                            size="18" name="numero"
                            pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" />
                        <label for="typenumero">Type</label> <input
                            id="typage" class="form-control"
                            type="hidden" value="0" name="fiche" /> <select
                            id="typenumero" name="typenumero">
                            <option value="portable">portable</option>
                            <option value="fixe">fixe</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="rue1">Rue 1</label> <input id="rue1"
                            class="form-control" required autofocus
                            placeholder="rue 1" type="text"
                            value="<c:out
                                    value="${ personne.getAdresse().getRue1() }" />"
                            size="18" name="rue1" maxlength="50" /> <label
                            for="rue2">Rue 2</label> <input id="rue2"
                            class="form-control" required autofocus
                            placeholder="rue 2" type="text"
                            value="<c:out
                                    value="${ personne.getAdresse().getRue2() }" />"
                            size="18" name="rue2" maxlength="50" /> <label
                            for="codepostal">Code postal</label> <input
                            id="codepostal" class="form-control"
                            required autofocus placeholder="code postal"
                            type="number"
                            value="<c:out
                                    value="${ personne.getAdresse().getCodePostal() }" />"
                            size="10" name="codepostal" min="1"
                            max="99999" /> <label for="ville">Ville</label>
                        <input id="ville" class="form-control" required
                            autofocus placeholder="ville" type="text"
                            value="<c:out
                                    value="${ personne.getAdresse().getVille() }" />"
                            size="18" name="ville" maxlength="50" />
                    </fieldset>
                    <input type="hidden" name="fiche"
                        value="<c:out
                                    value="${ personne.getId() }" />" />
                    <button class="btn btn-sm btn-primary" name="submit"
                        type="submit" value=""Enregistrer">Enregistrer</button>
                </form>

            </div>
        </div>
    </div>
    <!-- /.col-sm-4 -->
    <!-- col-sm-4 -->
    <div class="col-sm-4">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Information</h3>
            </div>
            <div class="panel-body">Merci de remplir cette
                nouvelle fiche</div>
        </div>
    </div>
    <!-- /.col-sm-4 -->
</c:if>
<%@ include file="../footer.jsp"%>