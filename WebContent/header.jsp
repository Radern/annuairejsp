<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="language" content="french" />
    <meta name="category" content="internet" />
    <meta name="Identifier-URL" content="http://www.memoliste.fr" />
    <meta name="author" content="Radern" />
    <meta name="description" content="annuaire, adresse, nom, prenom, telephone, mobile" />
    <meta name="keywords" content="" />
    <meta name="Date-Creation-yyyymmdd" content="2016/07/20" />
    <meta name="copyright" content="Copyright 2016 Radern" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title>Annuaire</title>
    <link rel="shortcut icon" type="image/x-icon" href="http://www.radern.com/images/favicon.ico" />

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="bootstrap/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bootstrap/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!-- Fixed navbar MENU -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Annuaire</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Compte<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                            <li><a href="formulaires?action=Ajouter">&nbsp;Ajouter un enregistrement</a></li>
                            <li><a href="consultation">&nbsp;Liste des enregistrements</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a>&nbsp;Rechercher</a></li>

                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">? <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="aide">Information</a></li>
                    </ul>
                </li>
            </ul>
            <!--/.nav-collapse -->
        </div>
    </div>
</nav>
<!-- /Fixed navbar MENU -->

<body>
<img src="${pageContext.request.contextPath}/images/1390.gif"/>
<img src="/images/1390.gif"/>
<img src="images/1390.gif"/>
<img src="<%=request.getContextPath()%>/images/1390.gif" alt="ici image"/>
<img src="<%=request.getContextPath()%>/images/1390.gif">
<!-- Contenair Principal -->
<div class="container">
<div class="row">
<br />
