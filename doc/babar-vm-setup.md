NAME: babar
ZONE: europe-west1-b
FIXED EXTERNAL IP: 104.199.54.108
Ephemeral Internal IP: 10.154.0.2

Your public IP address from mobile phone internet
92.184.97.175

Python Setup

sudo apt update

sudo apt install software-properties-common

sudo add-apt-repository ppa:deadsnakes/ppa

sudo apt update

sudo apt install python3.8

sudo apt update

sudo apt install build-essential zlib1g-dev libncurses5-dev libgdbm-dev
                 libnss3-dev libssl-dev libreadline-dev libffi-dev wget

sudo apt update

sudo apt install python3-pip

sudo pip3 install --upgrade pip

pip3 install ipython


## Clojure Setup

sudo apt update

sudo apt install default-jre

sudo apt install default-jdk

curl -O https://download.clojure.org/install/linux-install-1.10.1.739.sh

chmod +x linux-install-1.10.1.739.sh

sudo ./linux-install-1.10.1.739.sh

sudo apt update

Download the lein script:
https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein

Make it executable:
chmod a+x lein

Run it:
./lein

Move it to /usr/bin
sudo mv lein /usr/bin


## EMACS SETUP

sudo add-apt-repository universe
sudo apt update

sudo apt install emacs



## SBCL Setup

    sudo apt update
    sudo apt install sbcl


----

## PostsgreSQL Setup


PG default port is 5432

    sudo apt update

    sudo apt install postgresql  postgresql-client postgresql-contrib
	
	sudo systemctl start postgresql@12-main

### PG creates a default 'postgres' user role.

There are two ways to connect to the psql prompt (\q to exit)

    sudo -u postgres psql
	
### Edit configuration and replace locahost with your IP (or range)

Conf file: /etc/postgresql/9.5/main/pg_hba.conf

    sudo emacs /etc/postgresql/*/main/pg_hba.conf

    # IPv4 local connections, specify an IP range of 16K:
    host    all             all             92.184.0.0/16        md5

### Restore Postsgresql DB


    # First need to create the database
    CREATE DATABASE wikidb;

	# Resore using psql after creating DB.
	psql -d wikidb -f wikidb.sql
	
    # This doesn't work anymore (old method)
    \i /home/pierre/wikidb.sql;

    # or at the command line (old method)
    pg_restore -U postgres -d wikidb.sql


### Create additionalr oles

    CREATE ROLE pierre WITH SUPERUSER LOGIN CREATEDB
	ENCRYPTED PASSWORD '<pasword>';

    CREATE ROLE babar WITH SUPERUSER LOGIN CREATEDB
	ENCRYPTED PASSWORD '<pasword>';
	
	CREATE DATABASE wikidb OWNER babar;



### Edit postgresql.conf

Conf file: /etc/postgresql/*/main/postgresql.conf

    sudo emacs /etc/postgresql/9.5/main/postgresql.conf

    # Replace 'localhost' with '*'
    listen_addresses = '*'

Exit emacs and restart PG service

    sudo service postgresql restart


### Save & Restore Postsgresql 


    # Dump PG Database
    pg_dump -U postgres wikidb > wikidb.sql

    # Restore PG Database
    sudo -u postgres psql

    # First need to create the database
    CREATE DATABASE wikidb;

    # Now restore the dumpled sql file
    \i /home/pierre/wikidb.sql;

    # or at the command line
    pg_restore -U postgres -d wikidb.sql


### Uninstall PostgreSQL
  
    sudo apt-get --purge remove postgresql
    sudo apt-get purge postgresql*
    sudo apt-get --purge remove postgresql postgresql-doc postgresql-common
	
	sudo apt autoremove
	
	dpkg -l | grep postgres
	sudo apt-get --purge remove {POSTGRESS-PACKAGE NAME}
	
	sudo rm -rf /var/lib/postgresql/
	sudo rm -rf /var/log/postgresql/
	sudo rm -rf /etc/postgresql/
	
## Docker Setup


Remove any old versions
    
	sudo apt-get remove docker docker-engine docker.io containerd runc

Setup the repository

    sudo apt-get update
    sudo apt-get install apt-transport-https ca-certificates gnupg-agent software-properties-common

Add Docker GPG Key

    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

Verify key

    sudo apt-key fingerprint 0EBFCD88

Set up stable repository

    sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

Install Docker engine

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
