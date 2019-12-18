// contient la liste de tous les people reçue par l'api starwars
var liste = [];

/**
 * Action à réaliser lorsque le dom est chargé
 */
$(document).ready(function () {
  // on utilise jquery pour faire appel à l'api de starwars
  $.ajax({
    url: "https://swapi.co/api/people"
  }).then(function (data) {
    liste = data['results'];
    chargerMenu();
  });
});

/**
 * remplit le dropdown menu avec les noms de tous les people de la liste
 */
function chargerMenu() {

  liste.forEach(function (item) {
    console.log(item);
    //Pour chaque élément de la liste on affiche les info du perso dans une ligne du tableau
    
    //création d'une nouvelle ligne
    let tr = document.createElement('tr');
    
    //création de l'entête de la ligne
    let th = document.createElement('th');
    th.textContent = item["birth_year"];
    
    //création des celulles 
    let td1 = document.createElement('td');
    td1.textContent = item["name"];
    let td2 = document.createElement('td');
    td2.textContent = item["skin_color"];

    //insertion des éléments dans le tableau à l'interieur de la balise <tr> précèdemment créer
    document.getElementById('tbEvent').appendChild(tr).appendChild(th);
    document.getElementById('tbEvent').appendChild(tr).appendChild(td1);
    document.getElementById('tbEvent').appendChild(tr).appendChild(td2);
  });
}