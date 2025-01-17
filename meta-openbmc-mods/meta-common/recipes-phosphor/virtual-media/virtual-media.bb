SUMMARY = "Virtual Media Service"
DESCRIPTION = "Virtual Media Service"

SRC_URI = "git://git@github.com/Intel-BMC/virtual-media.git;protocol=ssh;branch=main"
SRCREV = "6165e07cd0ef6da314ed1ef4f58fe47b7d8112db"

S = "${WORKDIR}/git"
PV = "1.0+git${SRCPV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SYSTEMD_SERVICE:${PN} += "xyz.openbmc_project.VirtualMedia.service"

DEPENDS = "udev boost nlohmann-json systemd sdbusplus"

RDEPENDS:${PN} = "nbd-client nbdkit"

inherit cmake systemd

EXTRA_OECMAKE += "-DYOCTO_DEPENDENCIES=ON"
EXTRA_OECMAKE += "-DLEGACY_MODE_ENABLED=ON"

FULL_OPTIMIZATION = "-Os -pipe -flto -fno-rtti"
