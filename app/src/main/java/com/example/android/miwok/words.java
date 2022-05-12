package com.example.android.miwok;

public class words {
   public String defaltTranslation;
    public     String miwokTranslation;
    public int mAudioFileId;

    @Override
    public String toString() {
        return "words{" +
                "defaltTranslation='" + defaltTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", mAudioFileId=" + mAudioFileId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    private int mImageResourceId = no_provided_image;
    public  static  final int no_provided_image = -1;


    public words(String defaltTranslation,String miwokTranslation,int mAudioFileId){
        this.defaltTranslation = defaltTranslation;
        this.miwokTranslation = miwokTranslation;
        this.mAudioFileId = mAudioFileId;
    }
    public words(String defaltTranslation,String miwokTranslation,int mImageResourceId,int mAudioFileId){
        this.defaltTranslation = defaltTranslation;
        this.miwokTranslation = miwokTranslation;
        this.mImageResourceId =mImageResourceId;
        this.mAudioFileId = mAudioFileId;
    }

    public String getDefaltTraslation(){
        return defaltTranslation;
    }
    public String getMiwokTranslation(){
        return miwokTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }

    public  boolean hasImage(){
        return mImageResourceId != no_provided_image;
    }

    public int AudioFileId(){
        return mAudioFileId;
    }
}
