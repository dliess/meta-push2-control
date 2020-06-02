SUMMARY = "Push2Control image"

inherit populate_sdk populate_sdk_qt5
include recipes-core/images/core-image-base.bb

QT_PACKAGES = "\
    qtbase \
    qtbase-plugins \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtquickcontrols2 \
    qtquickcontrols2-qmlplugins \
    qtgraphicaleffects \
    liberation-fonts \
    qtsvg \
    qtsvg-plugins \
    qt3d \
    qt3d-qmlplugins \
    "
    
MISC_PACKAGES = "\
    libusb1 \
    "

APPLICATION_PACKAGES = "\
    kmscube \
    push2-control \
    "

TOOLCHAIN_TARGET_TASK_remove="qtwebkit qtwebkit-dev"
TOOLCHAIN_HOST_TASK_remove  ="qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qttools = "qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qtquick1 = "qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qtbase = "qtwebkit qtwebkit-dev"

MACHINE_FEATURES += "alsa wifi bluetooth usbhost"

IMAGE_INSTALL_append = " \
    ${QT_PACKAGES} \
    ${MISC_PACKAGES} \
    ${APPLICATION_PACKAGES} \
    "
