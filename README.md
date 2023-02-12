
# Feature Flag Library

 
Feature flags library helps to turns certain functionality on and off during runtime, without deploying new code. 
## Usage

1. Add JitPack to your project build.gradle

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
   }
}
```
2. Add the dependency in the application build.gradle

```
dependencies {
	    implementation 'com.github.Suchiq:FeatureFlagLibrary:1.0.0'
           }
```

3. usage in Activity or fragment 

```
lateinit var flag: FeatureFlagProvider

// initialize feature flag provider
flag = FeatureFlagProvider()
context?.let { flag.init(it) }

//set key value, this can be set based on backend response 

flag.setKeyValue(SHOULD_HIDE, true)
```
4. Control visibility by adding flag in activity/fragment


```
private fun showHideButton() {
        if (flag.getValue(SHOULD_HIDE)) {
            binding.buttonFirst.visibility = View.GONE
        } else {
            binding.buttonFirst.visibility = View.VISIBLE
        }
    }
```


 
## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
