// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}
//Training of fecth()
async function addGreetingElmer(){

    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();

    const dateContainer = document.getElementById('greeting-container');
    dateContainer.innerText = textFromResponse;
    
}
/** Fetches stats from the server and adds them to the page. */
async function getRandomFactAboutMeEN(){
    const responseFromServer = await fetch('/randomFactsAboutMe');
    const listFacts = await responseFromServer.json();
    const factContainer = document.getElementById('fact-container');
    console.log(listFacts.length);
    
    const fact = listFacts.factsInEN[Math.floor(Math.random() * (listFacts.length-1))];
    
    factContainer.innerHTML='';
    factContainer.appendChild(
        createImagesElement(fact.pathImage, fact.altAttribute)
    );

    factContainer.appendChild(
        createParagraphElement(fact.factText)
    );
    
}

/** Fetches stats from the server and adds them to the page. */
async function getRandomFactAboutMeES(){
    const responseFromServer = await fetch('/randomFactsAboutMe');
    const listFacts = await responseFromServer.json();
    const factContainer = document.getElementById('fact-container');
    
    const fact = listFacts.factsInES[Math.floor(Math.random() * (listFacts.length-1))];
    
    factContainer.innerHTML='';
    factContainer.appendChild(
        createImagesElement(fact.pathImage, fact.altAttribute)
    );

    factContainer.appendChild(
        createParagraphElement(fact.factText)
    );
    
}


/** Creates an <img> element*/
function createImagesElement(path, altAttribute) {
  const imgElement = document.createElement('img');
    imgElement.setAttribute('src', path);
    imgElement.setAttribute('alt', altAttribute);
    imgElement.setAttribute('style', 'width:150px; height:150px');
  return imgElement;
}
/** Creates an <p> element containing text. */
function createParagraphElement(text) {
  const pElement = document.createElement('p');
  pElement.innerText = text;
  return pElement;
}