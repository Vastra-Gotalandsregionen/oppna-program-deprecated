REFERENCE SYSTEMS
============================================================
The reference systems showcase different aspects of the Reference
Architecture (RA).


STRUCTURE
==============================
Each top-level directory represents a "system" in the RA-terminology.

Note: for use with Subversion, every "system"-level directory should have the
      "trunk" sub-directory containing the business-components. The "trunk"-dir
      has been left out here.
      The "system"-level dir should also be the Subversion-repository.


SYSTEMS
==============================

"addressbook"
--------------------
"addressbook" represents a system with components:

* "address" is an entity-oriented component with functionality for maintaining
  address-information. The "address"-component contains both a webapp (showing
  the use of Facelets and Spring-WebFlow) and an integration-service (intsvc,
  webservice) for system-to-system communication.

* "address-wsclient" is an example of a webservice client (process-oriented
  component). It's a very small example with strong focus on the client part of
  a webservice.
