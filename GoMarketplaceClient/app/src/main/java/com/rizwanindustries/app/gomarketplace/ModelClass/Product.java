package com.rizwanindustries.app.gomarketplace.ModelClass;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private int productId;
    private String productName;
    private String productSlug;
    private String productPrice;
    private String productDesc;
    private int productQty;
    private String productImage;
    private Merchant merchant;
    private ProductCategory category;


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public int getProductQty() {
        return productQty;
    }

    public String getProductImage() {
        return productImage;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Product(int productId, String productName, String productSlug, String productPrice, String productDesc, int productQty, String productImage, Merchant merchant, ProductCategory category) {
        this.productId = productId;
        this.productName = productName;
        this.productSlug = productSlug;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productQty = productQty;
        this.productImage = productImage;
        this.merchant = merchant;
        this.category = category;
    }

    protected Product(Parcel in) {
        productId = in.readInt();
        productName = in.readString();
        productSlug = in.readString();
        productPrice = in.readString();
        productDesc = in.readString();
        productQty = in.readInt();
        productImage = in.readString();
        merchant = in.readParcelable(Merchant.class.getClassLoader());
        category = in.readParcelable(ProductCategory.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(productId);
        dest.writeString(productName);
        dest.writeString(productSlug);
        dest.writeString(productPrice);
        dest.writeString(productDesc);
        dest.writeInt(productQty);
        dest.writeString(productImage);
        dest.writeParcelable(merchant, flags);
        dest.writeParcelable(category, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
