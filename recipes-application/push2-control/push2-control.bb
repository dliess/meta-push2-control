SUMMARY = "Midi controller Application for Push2"
SECTION = "Push2 application"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
DEPENDS += "qttools-native qtbase qtdeclarative qtquickcontrols2 alsa-lib libusb1"
PV = "0.1+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/dliess/Push2Control;branch=develop"

S = "${WORKDIR}/git"

inherit cmake
#OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += "-DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/${bindir}"
EXTRA_OECMAKE += "-DRTMIDI_BUILD_STATIC_LIBS=ON"
EXTRA_OECMAKE += "-DRtMidiApi=RtMidi::LINUX_ALSA"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 Push2Control ${D}${bindir}
    install -d ${D}${datadir}
    cp -r ${S}/MidiConfigs ${D}${datadir}
}

FILES_${PN} += "${datadir}/MidiConfigs"
