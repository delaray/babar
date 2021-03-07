#Lispbar

##Server Startup

cd /babar/lispbar  
sbcl --load source/server.lisp  

## Emacs Startup

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

6. (module-manager::load-module :english-parser)  
