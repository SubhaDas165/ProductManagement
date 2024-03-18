import axios from "axios";

const API_URL="http://localhost:8080"
class productService{
    saveProduct(product){
       return axios.post(API_URL+"/saveProduct",product);
    }
    getAllProduct(){
        return axios.get(API_URL+"/");
    }
    getProductById(id){
        return axios.get(API_URL+"/"+id);
    }
    deleteProductById(id){
        return axios.get(API_URL+"/deleteProduct/"+id);
    }
    editProduct(product,id){
        return axios.post(API_URL+"/editProduct/"+product.id,product);
    }
};
export default new productService;