
        $(document).ready(function(){
            $(".header_icon-bar").click(function(e){
                $(".header_menu").toggleClass('is-open');
                e.preventDefault();/*mettiamo questo codice in questo modo dato che la rimozione e l inerimento della classe is open avviene su un link dobbiamo far si che la pagina non venga ricaricata cosi da poter attivare l evento*/
            });
           
        });
