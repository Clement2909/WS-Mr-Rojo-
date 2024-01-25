import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  products = [
    { name: 'Buggatti chiron', type: 'sport', price: '$2000000', statut:'Vendue', image: '../assets/img/sport/sport_1.png' },
    { name: 'Chevrolet corvette 2022', type: 'sport', price: '$300000', statut:'disponible', image: '../assets/img/sport/sport_2.jpg' },
    { name: 'Hammer', type: 'tout-terrain', price: '$8500', statut:'Vendue', image: '../assets/img/tout-terrain/voiture-tout-terrain_4.jpg' },
    {name: 'Duster', type: 'normal', price: '$3500', statut:'Vendue', image: '../assets/img/normal/normal_2.jpg' },
    { name: 'Land-rover', type: 'tout-terrain', price: '$10000', statut:'disponible', image: '../assets/img/tout-terrain/voiture-tout-terrain_6.jpg' },
    { name: 'Mercedes', type: 'sport', price: '$300000', statut:'disponible', image: '../assets/img/sport/sport_4.jpg' },
    {name: 'compact', type: 'normal', price: '$3500', statut:'Vendue', image: '../assets/img/normal/normal_1.jpg' },
    {name: 'compact', type: 'normal', price: '$2500', statut:'Disponible', image: '../assets/img/normal/normal_3.jpeg' },
    // Ajoutez d'autres produits
  ];
  constructor() {}

}
