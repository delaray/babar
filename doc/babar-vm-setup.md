# Babar VM Setup Instractions

NAME: babar
ZONE: europe-west2-c	
FIXED EXTERNAL IP: 35.189.76.240
Ephemeral Internal IP: 10.154.0.2

Your public IP address from mobile phone internet
92.184.97.175


## PYTHON SETUP

    sudo apt update

    sudo add-apt-repository ppa:deadsnakes/ppa

    sudo apt install python3.12

Then update the symbolic links to python and python3 in /usr/bin

Install PIP by downloading get_pip.py scrupt and update symbolic links

    sudo apt update

    sudo apt install python3-pip

    sudo pip3 install --upgrade pip

    pip3 install ipython


## ORACLE JDK SETUP

    sudo apt update

    sudo apt install default-jre

    sudo apt install default-jdk


## OPEN JDK SETUP

    sudo apt-get install -y software-properties-common wget apt-transport-https
	
    sudo mkdir -p /etc/apt/keyrings
	
    wget -O - https://packages.adoptium.net/artifactory/api/gpg/key/public | sudo tee /etc/apt/keyrings/adoptium.asc
	
    echo "deb [signed-by=/etc/apt/keyrings/adoptium.asc] https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME/{print$2}' /etc/os-release) main" | sudo tee /etc/apt/sources.list.d/adoptium.list
	
    sudo apt-get update
	
    sudo apt-get install -y temurin-17-jdk
	
    java -version

## CLOJURE SETUP

    curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh

    sudo mv lein /usr/local/bin/lein

    sudo chmod a+x /usr/local/bin/lein

    lein version 

## EMACS SETUP

sudo add-apt-repository ppa:kelleyk/emacs

sudo apt update

sudo apt install emacs

-----------------------------------------------------------------
Miniconda
-----------------------------------------------------------------

     wget https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh

     
-----------------------------------------------------------------
SBCL SETUP
-----------------------------------------------------------------

sudo apt update

sudo apt install sbcl


-----------------------------------------------------------------
## POSTSGRESQL SETUP
-----------------------------------------------------------------

PG default port is 5432

sudo apt update

sudo apt install postgresql  postgresql-client postgresql-contrib

PG creates a default 'postgres' user role. There are two ways
to connect to the Postgres prompt (\q to exit)

### Method 1
sudo -i -u postgres
psql

#### Method 2
sudo -u postgres psql

### Create new users pierre & babar
sudo -u postgres createuser --interactive

User: pierre

User: babar

Go onto psql to set PWD

pierre@babar:/etc/postgresql/12$ sudo -u postgres psql template1
psql (12.19 (Ubuntu 12.19-0ubuntu0.20.04.1))
Type "help" for help.

    template1=# ALTER USER postgres with encrypted password '<pwd>';
    ==> ALTER ROLE
    template1=# ALTER USER babar with encrypted password '<pwd>';
    ==> ALTER ROLE
    template1=# ALTER USER pierre with encrypted password '<pwd>';
    ==> ALTER ROLE
    template1=# \q
	
### Edit configuration pg_hba.conf

    sudo emacs /etc/postgresql/12/main/pg_hba.conf

Add IP4 host:

    host    all             all             92.184.0.0/16        md5

### Edit configuration postgresql.conf

Change /etc/postgresql/12/main/postgresql.conf

    sudo emacs /etc/postgresql/12/main/postgresql.conf
	
Replace localhost with '*' in listen statement.


### Restart PG service

    sudo service postgresql restart


## SAVE & RESTORE POSTSGRESQL 

### Dump PG Database

    pg_dump -U postgres wikidb > wikidb.sql

### Restore PG Database

    sudo -u postgres psql

First need to create the database

    CREATE DATABASE wikidb;

Now restore the dumpled sql file

1. From CLI

   postgresql -f <filename> -d wikidb
   
2. From psql  

    \i /home/pierre/wikidb.sql

3. Using pg_restore

    pg_restore -U postgres -d wikidb.sql

#-----------------------------------------------------------------
# Docker Setup
#-----------------------------------------------------------------

# Remove any old versions
sudo apt-get remove docker docker-engine docker.io containerd runc

# Setup the repository
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

# Add Docker GPG Key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

# Verify key
sudo apt-key fingerprint 0EBFCD88

# Set up stable repository
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

# Install Docker engine
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io

#-----------------------------------------------------------------
# Verify Docker Installation
#-----------------------------------------------------------------

# Verify Docker Installation
sudo docker run hello-world

# Prints the following to terminal

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:

docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:

https://docs.docker.com/get-started/

#-----------------------------------------------------------------
# GIT Tricks
#-----------------------------------------------------------------

# Removing accidently comitted large files

git filter-branch --tree-filter 'rm -rf path/to/your/file' HEAD

#-----------------------------------------------------------------
#End of File
#-----------------------------------------------------------------
