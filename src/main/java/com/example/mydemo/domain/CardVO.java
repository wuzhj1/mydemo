package com.example.mydemo.domain;

public class CardVO {
    private String pk_card;
    private String asset_code;
    private String asset_name;
    private String card_code;



    public String getPk_card() {
        return pk_card;
    }

    public void setPk_card(String pk_card) {
        this.pk_card = pk_card;
    }

    public String getAsset_code() {
        return asset_code;
    }

    public void setAsset_code(String asset_code) {
        this.asset_code = asset_code;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    @Override
    public String toString() {
        return "CardVO{" +
                "pk_card='" + pk_card + '\'' +
                ", asset_code='" + asset_code + '\'' +
                ", asset_name='" + asset_name + '\'' +
                ", card_code='" + card_code + '\'' +
                '}';
    }

    public String getCard_code() {
        return card_code;
    }

    public void setCard_code(String card_code) {
        this.card_code = card_code;
    }
}
