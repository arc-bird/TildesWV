# TildesWV

TildesWV is just a WebView wrapper for the social media network Tildes (https://tildes.net/). It does not interact with the Tildes API or provide any functionality beyond that of the Tildes website. Its only benefit is that it allows one to access Tildes from an app using the native Android WebView system, rather than having to use a full-blown web browser.

Users are (should be) able to log in to their Tildes account, provided they have one, or browse anonymously. The WebView does not delete cookies, so preferences and accounts should remain, at least for a while. It does allow users to return to a previous page via their phone's 'back' button.

This app is essentially a fork of woheller69's gptAssist (https://github.com/woheller69/gptassist), with some limiting functionality removed and the ability to open links within the view, instead of being redirected to your favorite mobile browser.

I hope it suits your needs!

## Installation and Updating

Since I have not (and don't really plan to) listed this on an app store or repository, the app must be downloaded from the [releases page](https://github.com/Sipesy/TildesWV/releases). Once you are there, simply find the latest release (at this time, v0.1.1-alpha) and click or tap on `app-release.apk` to download the release to your device.

To install the app, you may have to enable *Install Apps from Unknown Sources* in your device settings. Most newer phones will automatically prompt you to do this when you try to install an unknown app, but other devices may simply deny the install. To use the app on such devices, you will have to enable [developer options](https://developer.android.com/studio/debug/dev-options) and toggle the setting from there.

If a new version of the app is released (again, the app is not listed in any repositories at this time), you will have to return to the releases page and manually download and install the latest release. On the bright side, there likely won't be many changes to worry about.

## License

This app is licensed under the GPLv3.

This app uses code from gptAssist by woheller69 (https://github.com/woheller69/gptassist), which also uses parts of DivestOS's GMaps WV (https://hitlab.com/divested-mobile/maps), both of which are licensed under GPLv3.

## Contributing

Please, feel free! I am not an Android developer and this was cobbled together with whatever information I could find. Make issues and pull requests as you wish, fork as you like.
