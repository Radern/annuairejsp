# annuairejsp

Petit projet personnel d'annuaire
    - HTML5
    - Mysql
    - J2EE (avec DAO)
    - Bootstrap
   
- Cette version permet :
     - ajouter une personne (avec adresse et téléphone)
     - modifier une personne
     - voir la liste des personnes (avec pagination de 2 par 2...)
     - voir une personne en particulier
     - supprimer une personne.
     
- La recherche n'est pas implantée.
- Une gestion DAO est implantée, cela fonctionne pour une Bdd, mais pas encore implantée pour XML.
- Ce projet est à but personnel, et n'est donc pas pleinement utilisable en prod, car peu sécurisé.

- Pour le mettre en place, il y a un script SQL donné.
- Puis il faut adapter la connection dans com.annuaire.dao.AbstractDAOFactory.java
