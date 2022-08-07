// fetch("/getAll").then( res => {
//     res.json().then(body => {
//         document.body.innerHTML = "<h1>Get ALL</h1>";
//         body.forEach(i => {
        
//             var item = document.createElement("p");
//             item.innerHTML = `${i.firstName}, ${i.lastName}`;
//             document.body.appendChild(item);
        
//         })
//     })
// }).catch(err => {
//     console.log(err)
//     document.body.innerHTML= `<p>Error: ${err.message}</p>`
// })

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

function submit(){
    updateCall
}