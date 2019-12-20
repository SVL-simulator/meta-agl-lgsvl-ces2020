**README.md for the 'meta-agl-lgsvl-ces2020' layer.**

meta-agl-lgsvl-ces2020, demo components and targets developed by LGE
====================================================================

The layer 'meta-agl-lgsvl-ces2020' provides the LGSVL demo for
CES 2020 in AGL booths.

Quick start guide
-----------------

1. Fetch AGL halibut with repo tool.

```bash
repo init -b halibut -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo
repo sync
```

2. Clone this repository in same path of other layers.

3. Call to aglsetup.sh adding svl-ces2020 as a feature.

I.e. for NUC:

```bash
source meta-agl/scripts/aglsetup.sh -f -m intel-corei7-64 -b build agl-devel svl-ces2020
```

3.1 Change branch of meta-agl-devel to the one for the demo:

```
cd meta-agl-devel
git remote add igalia-github git@github.com:Igalia/meta-agl-devel.git
git fetch igalia-github
git checkout halibut.ces2020

4. Build the target agl-demo-platform

```bash
bitbake agl-demo-platform
```

5. Flash the resulting build.

I.e. for NUC, flashing on /dev/sdX (replace with your actual target device):

```bash
xzcat tmp/deploy/images/intel-corei7-64/agl-demo-platform-intel-corei7-64.wic.xz | sudo dd of=/dev/sdX bs=4M
```

Note NUC does not support booting from SD card, so better use a USB storage.

Agate Console deployment keys
-----------------------------

In case you want to add predefined config.js for Agate console app:

1. Add agl-localdev to the list of templates in aglsetup.sh:

```bash
source meta-agl/scripts/aglsetup.sh -f -m intel-corei7-64 -b build agl-devel svl-ces2020 agl-localdev
```

2. Copy the config.js populated file to /build-path-foo/agl-halibut/meta-agl-lgsvl-ces2020/agate-console-config/config.js
(with whatever path you are using for building).

3. On conf/local.dev.inc add these lines:

```
FILESEXTRAPATHS_prepend_pn-agate-console := "/build-path-foo/agl-halibut/meta-agl-lgsvl-ces2020/agate-console-config:"
SRC_URI_append_pn-agate-console = " file://config.js"
do_compile_append_pn-agate-console() {
  cp ${WORKDIR}/config.js ${S}/console/dist/assets/config.js
}
```

4. Or you can just copy the file to the running device with scp (once agate-console has been installed).
The path is '/var/local/lib/afm/applications/webapps-agate-console/1.0/assets/config.js'

Supported Machines
------------------

Reference hardware:

* Intel NUC

