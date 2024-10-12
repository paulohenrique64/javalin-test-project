var form = document.querySelector("form");

form.addEventListener("submit", (event) => {
    event.preventDefault();
    const input = document.querySelector("input");
    const formData  = new FormData();

    for (let i = 0; i < input.files.length; i++) {
        formData.append("files", input.files[i]);
    }
      
    fetch("http://localhost:7070/upload", {
            method: "POST",
            body: formData
        })
        .then(function(res){ 
            console.log(res) 
            if (res.status == 200) 
                sucess();
            else 
                error();
        })
        .catch(function(res){ 
            console.log(res) 
            error();
        })
})

function sucess() {
    alert("arquivos enviados com sucesso")
}

function error() {
    alert("falha ao enviar os arquivos")
}



