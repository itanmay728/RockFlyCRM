const search = () => {
    //console.log("searching")

    let query=$("#search-input").val();

    if(query==""){
        $(".search-result").hide();
    }else{
        //search
        //console.log(query);

        //sending request to server

        let url=`http://localhost:8080/search/${query}`;

        fetch(url)
           .then((response)=>{
            return response.json();
        })
           .then((data) => {
            //data...
            //console.log(data);

            //convert data into html and insert in the result box
            let text = `<div class='list-group'>`;

            data.forEach((customer) => {
                //making a link to open particular customer details on another page
                text+=`<a href='/admin/customer/${customer.id}' class='list-group-item list-group-item-action'> ${customer.shopName}</a>`

            });
            text+=`</div>`;

            $(".search-result").html(text);
            $(".search-result").show();

        });

    }
};