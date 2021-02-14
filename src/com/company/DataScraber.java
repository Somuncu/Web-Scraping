package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataScraber {


    public ArrayList<Products> getProduct() throws IOException {

            Document doc = Jsoup.connect("https://www.koton.com/tr/kadin/giyim/dis-giyim/kaban/c/M01-C02-N01-AK104-K100071").get();
           // Elements urlProductElements = doc.select("div.productGrid ");
            ArrayList<Products> products = new ArrayList<Products>();

            Elements urlProductElements = doc.select("div.product-item");
            for(Element urlProductElement : urlProductElements){
                Elements wrapper = urlProductElement.select("div.wrapper > figure").select("a");
                Element hrefElement = wrapper.first();
                String href = hrefElement.attr("href");
                Products product = new Products();
                product = insertProduct(href);
                products.add(product) ;

            }

            return products;

    }

    private Products insertProduct(String href) {
        try {

            Products product = new Products();
            Document docProduct = Jsoup.connect("https://www.koton.com/"+href).get();
            Element docProductTitleElement = docProduct.select("div.productDetailDescription > h1").first();
            String docProductDescription = docProductTitleElement.text();
            String[] documentTitleColorElement = docProductDescription.split("-");
            String title = documentTitleColorElement[0];
            String color = documentTitleColorElement[1];


            Element kategoriElement = docProduct.select("div.breadcrumb > ul").first().child(4);
            Element elementkategori = kategoriElement.select("a").get(0);
            String kategori = elementkategori.text();

            String priceElements = docProduct.select("div.price span").text();
            String[] priceList = priceElements.split(" ");
            Double price=null;
            Double oldprice=null;
            if(priceList.length>1){
                String value = priceList[1].replace('₺',' ').replace(',','.');

                price = Double.valueOf(value);
                product.setPrice(price);
                oldprice =  Double.valueOf(priceList[0].replace('₺',' ').replace(',','.'));
                product.setOldprice(oldprice);
            }
            else{
                oldprice = Double.valueOf(priceList[0].replace('₺',' ').replace(',','.'));
                product.setPrice(0.0);
                product.setOldprice(oldprice);
            }


            Element imageUriElement = docProduct.select("div.productDetailImageContainer img").first();
            String imageUri = imageUriElement.attr("alt-src");

            Elements imageUrlElement = docProduct.select("div.productDetailImageContainer img");
            String imageUrls = "";
            for(Element image : imageUrlElement){
                if(imageUrls.equals("")){
                    imageUrls = image.attr("alt-src");
                }else{
                    imageUrls = imageUrls + ',' + image.attr("alt-src");
                }

            }
            String listimageuri = imageUriElement.attr("alt-src");

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            product.setDatePublished(date.toString());


//            Element modelElement = doc.select("ul.classifiedInfoList > li").get(2);
//            String model = modelElement.text();
            product.setId(href);
            product.setTitle(title);
            product.setDescription(docProductDescription);
            product.setColor(color);
            product.setProductCategory(kategori);
            if(priceList.length>1){
                product.setDiscount(true);
            }else{
                product.setDiscount(false);
            }
            product.setImageUri(imageUrls);

            return product;
        } catch (IOException e) {
            System.out.println("Hatalı URL" + " = "+ e.getMessage() );
            //e.printStackTrace();
            return null;
        }
    }
}
