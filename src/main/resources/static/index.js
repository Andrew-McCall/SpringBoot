function updateCall(item){
    fetch(`/update?id=${item.id}`,{
        method:"POST",
        body:JSON.stringify(item),
        headers:{
            "Content-Type":"application/json"
        }
    
    }).then(res => {
    
    
        res.json().then(body => {
            document.body.innerHTML = JSON.stringify(body)
        })
    
    
    }).catch(err =>{
        console.log(err)
        document.body.innerHTML= `<p>Error: ${err.message}</p>`
    })
}