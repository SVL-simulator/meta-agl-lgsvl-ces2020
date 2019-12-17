SUMMARY = "The software for SVL CES2020 demo"
DESCRIPTION = "A set of packages belong to SVL CES2020 Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-demo-platform-svl-ces2020 \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    packagegroup-agl-demo-platform-html5 \
    "

# add packages for demo platform (include demo apps) here
RDEPENDS_${PN} += " \
    "

# add packages for WAM
RDEPENDS_${PN} += " \
    agate-console \
    enactbrowser-service \
    html5-dashboard \
    html5-homescreen \
    html5-mediaplayer \
    html5-mixer \
    html5-hvac \
    html5-launcher \
    html5-settings \
    webapp-samples \
"
