Environment Variables:

# Project Directories
BABAR_DIR
BABAR_CLOBAR_DIR
BABAR_PYBAR_DIR
BABAR_LISPBAR_DIR

# Server Ports
BABAR_CLOBAR_PORT
BABAR_PYBAR_PORT
BABAR_LISPBAR_PORT

# DB Access
BABAR_DB_USER
BABAR_DB_PW
BABAR_DB_NAME
BABAR_DB_PORT
BABAR_EMAIL_USER
BABAR_EMAIL_PWD



Lispbar Startup Instructions:

In Emacs:

   1. Start SBCL
      M-x slime

   2. Load Quickilisp
      (load "c:/Users/pierre/quicklisp/setup.lisp")

   3. Load drakma with quicklisp
      (ql:quickload :drakma)

   4. Load postmodern with quicklisp
      (ql:quickload :postmodern)

   5. Load GBBopen startup file
      (load "c:\\projects\\clos\\GBBopen\\startup.lisp")


   3. (module-manager::load-module :english-parser)

   4. #   b a b a r  
 