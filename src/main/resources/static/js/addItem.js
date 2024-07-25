
function getProducts(productSpecification, numericSize) {
   // Get the category id
   var productId = $('#selectProductType').val();
   console.log(productId);

   if (!productId) {
       console.error("No product ID selected.");
       return;
   }

   // Fetching product specifications
   $.get("/manager/getproductSpecification/" + productId, function(data) {
       var specDropdown = document.getElementById(productSpecification);
       
       specDropdown.length = 0;  // Clear existing options
       specDropdown.options[0] = new Option('Select Specification', '');
       specDropdown.selectedIndex = 0;
       // Add new options
       $.each(data, function(key, value) {
           specDropdown.options[specDropdown.options.length] = new Option(value.specification, value.id);
       });
   }).fail(function() {
       console.error("Failed to fetch product specifications.");
   });

   // Fetching sizes
   $.get("/manager/getsize/" + productId, function(data) {
      
       var sizeDropdown = document.getElementById(numericSize);
      
       sizeDropdown.length = 0;  // Clear existing options
       sizeDropdown.options[0] = new Option('Select size', '');
       sizeDropdown.selectedIndex = 0;
       // Add new options
       $.each(data, function(key, value) {
           sizeDropdown.options[sizeDropdown.options.length] = new Option(value.sizes, value.sizeId);
       });
   }).fail(function() {
       console.error("Failed to fetch sizes.");
   });
}
