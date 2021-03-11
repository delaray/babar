# Babar Knowledge System

![Logo](doc/images/brain-activity.jpg)

Babar is an independent research project of mine in the field of Artificial Intelligence.

One of the goals of this project is to leverage both neural and symbolic AI rather than perceive them at odds with each other. In this context several approaches are explored which can be seen as leveraging model-based AI (reductionism) as a bootstrapping mechanism for model-free AI (holism).

The Babar knowledge system is named in homage to John McCarthy who not only invented the LISP programming language but also coined the term “Artificial Intelligence” in 1958.

Babar is implemented in several programming languages including CLOS, Python and Clojure.
THe Clojure module, Clobar, implements the user interface and web development aspects.
The Python module, Pybar, is used for web scraping and crawling as well as the neural network aspects of the project. Finally the CLOS module, Lispbar, is used to implement the symbolic AI elements of the project.


## Environment Variables

The following environment variables are used to parameterize the various communication and autrhentication elements.

### Project Directories

Each module has it's own directory, nut there a common directory for shared data.

BABAR_DIR  
BABAR_CLOBAR_DIR  
BABAR_PYBAR_DIR  
BABAR_LISPBAR_DIR  

### Server Ports  
BABAR_CLOBAR_PORT (*default is 3000*)
BABAR_PYBAR_PORT  (*default is 4000*)
BABAR_LISPBAR_PORT (*default is 5000*)

### Database Access  
BABAR_DB_USER  
BABAR_DB_PW  
BABAR_DB_NAME  
BABAR_DB_PORT  
BABAR_EMAIL_USER  
BABAR_EMAIL_PWD  

## Clobar

HTML Generation
Javascript Libraries


## Pybar

### Crawling and scraping Wikipedia  
### Other data sources
### LSTM based Neural Networks

## Lispbar

[Startup instructions](doc/lispbar.md)

### The English Language Parser

[Parser Documentation](doc/parser.md)

### Learning Grammar Productions

### Knowledge Extraction

### Clausal Form Logic

### Semantic Nets

### Clustering Wikipedia Topics

### Inductive Logic Programming / FOIL

Applications
    Browsing Wikipedia
    Classifying Google Search Results

## Postgres

[Wikipedia Graph](doc/db.md)



