# Image-Gallery
Android Image Gallery Library.

You can provide an array of image URLs and have a viewpager based activity for viewing all the images.
## Download
Get it through gradle :
In Project's build.gradle :

```
repositories {
    maven { url 'https://jitpack.io' }
}
```
In your app module's build.gradle file
```
dependencies {
    compile 'com.github.hemant3370:Image-Gallery:-SNAPSHOT'
}
```
In your image grid's click listener initiate the gallery Activity like this:

     Intent mIntent = new Intent(Gallery.this, ImageTabsActivity.class);
                mIntent.putExtra("files",urls.toArray(new String[urls.size()])); //urls list or array
                mIntent.putExtra("index", position);  // position of the item clicked
                startActivity(mIntent);
