<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/Jatin-Shihora/Product_Tracker">
  </a>

  <h3 align="center">Product Tracker App</h3>

  <p align="center">
    A Product Tracker App for local shop keepers. Developed with love for India. 
    <br />
    <a href="https://github.com/Jatin-Shihora/Product_Tracker"><strong>Explore the Repo »</strong></a>
    <br />
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#design workflow">Design Workflow</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project


|Logo|Main Screen|
|---|---|
|![ic_all_store](https://user-images.githubusercontent.com/75017563/137791368-c54f6158-1aec-4ebd-a0b4-8da733d7343e.png)|![Main_Activity](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_tab.jpg)|


As the name suggests the app is developed for the purpose of tracking the products of a shop or a godawn .The main structure of the app is like an iventory tracking system which enables the shop keeper to track his/her products on daily basis and which will help to procure the goods in an optimized manner and also in a clean manner . Usually the shop Keepers have tedency to write everthing in traditional pen-paper system which later becomes tedious for them to track or sometimes it may get slipped through their mind and in the end they loose the track and the chaos begins . So to prevent this chaos the app is being deveoped.

Of course,my app does not have everything and since your needs may be different or I may have missed some corner cases or features . So I'll be adding more features in the near future. You may also suggest changes by forking this repo and creating a pull request or opening an issue. Thanks to all the people who have inspired me for working towards this app :) !!

A list of commonly used resources that I find helpful are listed in the acknowledgements ;).

### Built With

This App was build with the help of Java for coding the brain of the app, XML for beautification & SQLite for adding Memory to the brain . 
* [Java](https://docs.oracle.com/en/java/)
* [XML](https://developer.mozilla.org/en-US/docs/Web/XML/XML_introduction)
* [SQLite](https://www.sqlite.org/index.html)



<!-- GETTING STARTED -->
## Getting Started :

### App Compatibility

Android device running with Android OS 4.0.4 (API Level 15) or above. Best experienced on Android Lolipop 5.0 and above. The app was tested on api level 27,29,30 . Designed for Phones and NOT for Tablets.

### Prerequisites

Before getting in the project you should have the basic knowledge of the following
* Java
* XML
* SQLite
* AndroidX
* Android SDK
* Android Studio

### Installation


1. Clone the repo 
   ```sh
   git clone https://github.com/Jatin-Shihora/Product_Tracker.git
   ```
2. Run the Gradle build Properly .
3. Develop some more amazing features .

<!-- USAGE EXAMPLES -->
## Usage

The Main use of this app is that it allows a Store to keep track of the inventory of its Products across the listed Suppliers of Products, along with their Price and Pictures of the Product.Thus to reduce the chaos that occurs due to traditional pen-paper sytem to track your products and that way this app works as an replacement to that old custom to make life of shopkeeper a bit more convenient.

<!-- Design Workflow -->
## Design Workflow

App is structured as an Tracking App that tracks the products of the shopkeeper,suppliers engagements to the products & sales of the products via suppliers input to the products.

### The Home Screen or the Main Activity of the App

The Main Activity displays a tab Layout with three different Tabs naming Prouducts,Suppliers,Sales -

1. Products Tab
Shows a list of Products configured if any.
Allows to configure a New Product in the database.
2. Suppliers Tab
Shows a list of Suppliers configured if any.
Allows to configure a New Supplier in the database.
3. Sales Tab
Shows a list of Products configured with their Sales information.
Allows to quick sell a quantity of any Product shown.

|Products Tab|Supplier Tab|Sales Tab|
|---|---|---|
|![Product Tab](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_tab.jpg)|![Supplier Tab](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/supplier_tab.jpg)|![Sales Tab](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/sales_tab.jpg)|

### The below are the some more images of the app so that you can gauge the app more precisely

### Product Tab

|Blank Products Configuration Activity|Filled Products Configuration Activity|Product CardView|
|---|---|---|
|![Products config activity blank](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/empty_product_config_activity.jpg)|![Product config activity filled](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_config_activity_filled.jpg)|![Product CardView](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_cardview.jpg)|

|Prouduct Images Gallery|Product Image Picked|Product Picker|
|---|---|---|
|![Prouduct images](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_images.jpg)|![Product image picked](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_image_picked.jpg)|![Product picker](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/product_picker.jpg)|

### Supplier Tab

|Supplier Configuration Activity-1|Supplier Configuration Activity-2|Supplier CardView|
|---|---|---|
|![Supplier config activity filled-1](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/supplier_config_activity_filled-1.jpg)|![Supplier config activity filled-2](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/supplier_config_activity_filled-2.jpg)|![Supplier CardView](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/supplier_cardview.jpg)|


### Sales Tab

|Sales Configuration Activity|Sales CardView|
|---|---|
|![Sales config activity](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/sales_config_activity.jpg)|![Sales CardView](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/sales_cardview.jpg)|

### Good UI Practices

|Conformation dialogue box|Image picker|Invalid format example|
|---|---|---|
|![Conformation before deleting](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/good_ui_practive.jpg)|![Image picker](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/image_picker.jpg)|![Invalid format example](https://github.com/Jatin-Shihora/Product_Tracker/blob/main/App%20images/invalid_gmail_examples.jpg)|

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### **Note** :
 Make sure you push only those files that you have changed .  

<!-- LICENSE -->
## License

```
Copyright 2021 Jatin C Shihora

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
   
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



<!-- CONTACT -->
## Contact
Feel free to contact if you want to discus some ideas or issues .I will be happy to hear you all. 

Linkedin(Jatin Shihora) - [https://www.linkedin.com/in/jatin-shihora/](https://www.linkedin.com/in/your_username/) 

Mail - jatinshihora0123@gmail.com

Project Link: [https://github.com/Jatin-Shihora/Product_Tracker](https://github.com/your_username/repo_name)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [ Apache License 2.0](http://www.apache.org/licenses/)
* [Official website of Andorid developers](https://developer.android.com/)
* [Font Awesome](https://fontawesome.com)
* [Icons8](https://icons8.com/)



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
