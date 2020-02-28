package com.rizwanindustries.gomarketplacemerchant.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private int productId;
    private String productName;
    private String productSlug;
    private String productQty;
    private String productPrice;
    private String productDesc;
    private Merchant merchant;
    private Category category;

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public String getProductQty() {
        return productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public Category getCategory() {
        return category;
    }

    public Product(int productId, String productName, String productSlug, String productQty, String productPrice, String productDesc, Merchant merchant, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productSlug = productSlug;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.merchant = merchant;
        this.category = category;
    }

    protected Product(Parcel in) {
        productId = in.readInt();
        productName = in.readString();
        productSlug = in.readString();
        productQty = in.readString();
        productPrice = in.readString();
        productDesc = in.readString();
        merchant = in.readParcelable(Merchant.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(productId);
        dest.writeString(productName);
        dest.writeString(productSlug);
        dest.writeString(productQty);
        dest.writeString(productPrice);
        dest.writeString(productDesc);
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
