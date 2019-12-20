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

Supported Machines
------------------

Reference hardware:

* Intel NUC

