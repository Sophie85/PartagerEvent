
var liste = [];

$(document).ready(function () {
    // on utilise jquery pour faire appel à l'api
    $.ajax({
        url: "/events"
    }).then(function (data) {
        liste = data;
        chargerEvent();
        ajouterEvenement();
        idRecherche();
    });
});

function chargerEvent() {

    liste.forEach(function (item) {
        //console.log(item);
        //Pour chaque élément de la liste on affiche les info du perso dans une ligne du tableau

        //création d'une nouvelle ligne
        let tr = document.createElement('tr');

        //création de l'entête de la ligne
        let th = document.createElement('th');
        th.textContent = item["date"];

        //création des celulles 
        let td1 = document.createElement('td');
        td1.textContent = item["titre"];
        let td2 = document.createElement('td');
        td2.textContent = item["ville"];

        //insertion des éléments dans le tableau à l'interieur de la balise <tr> précèdemment créer
        document.getElementById('tbEvent').appendChild(tr).appendChild(th);
        document.getElementById('tbEvent').appendChild(tr).appendChild(td1);
        document.getElementById('tbEvent').appendChild(tr).appendChild(td2);

        tr.addEventListener('click', function (event) {
            remplirCardDetails(item);
           // document.getElementById('details').textContent = item["details"];
           // document.getElementById('detailsPhoto').src = item["image"];
        })
    });
}

//remplir card
function remplirCardDetails(item) {
    document.getElementById('details').textContent = item["details"];
    document.getElementById('detailsPhoto').src = item["image"];
}


// remplir le formulaire
function ajouterEvenement() {

    document.getElementById("butou").addEventListener('click', function (e) {
        let img;
        if (document.getElementById("formGroupImage").value) {
            img = document.getElementById("formGroupImage").value;
        }
        else {
            img = "image/evenement.jpg";
        }
        $.post("/ajout", {
            date: document.getElementById("inputDate").value,
            titre: document.getElementById("formGroupTitre").value,
            ville: document.getElementById("formGroupVille").value,
            details: document.getElementById("formGroupDescription").value,
            image: img
        });
        document.location.reload(true);
    });
}


function idRecherche() {
    document.getElementById("search").addEventListener("click",function(event){
        $.ajax({
            url:"http://localhost:8080/search?id="+document.getElementById("searchId").value,
            success : (remplirCardDetails),
            error : (error)
        })
    });
}

function error(data){
    console.log("coucou");
    document.location.href="/err"
}