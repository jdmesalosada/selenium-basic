function create() {
        setTimeout(function () {

         var e = document.getElementById("createBtn");
         e.style.display = "block";
         e.style.border =  "none";
         e.disabled = true
         e.class = ".button4"


        var h1 = document.createElement('h1');
        h1.textContent = "Test Automation is Awesome!!!";
        h1.setAttribute('class', 'note');
        h1.setAttribute('id', 'jmconsultant');
        document.body.appendChild(h1);
             }, 2000);
      }