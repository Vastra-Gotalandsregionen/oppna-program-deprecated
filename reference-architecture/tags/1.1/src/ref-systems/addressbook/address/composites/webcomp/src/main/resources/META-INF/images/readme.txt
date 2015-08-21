All "company"/"organization"-wide images/stylesheets etc should be placed in a
non-system specific artefact like for example "vgr-common-images.jar" and refered
to as a Maven-dependency (instead of duplicating those resources for every
system).
Those resources should be prefixed with and named like for example:
"vgr-common-image-small-logo.gif".

