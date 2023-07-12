function checkOk(){
    let ok = document.querySelector("input[name='ag']:checked");
    let nextBtn = document.querySelector(".nextBtn");
    if(ok.value == 'ok'){
        nextBtn.classList.replace("btn-secondary", "btn-dark")
        nextBtn.addEventListener("click", goSignUpPage)
    }else{
        nextBtn.classList.replace("btn-dark", "btn-secondary")
        nextBtn.removeEventListener("click", goSignUpPage)
    }
}

function goSignUpPage(){
    location.href = "/users/signUp";
}