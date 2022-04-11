---
layout: page
title: Channe Chwa's Project Portfolio Page
---

### Project: TAddressBook

[TAddress Book](https://github.com/AY2122S2-CS2103-F10-1/tp) is a desktop app for CS2030S Teaching Assistants (TAs) to manage students and labs, in particular the grading process of lab assignments.
It is based on [AddressBook Level 3](https://se-education.org/addressbook-level3/).

Given below are my contributions to the project. The code contributed can be found at this [Reposense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=channne&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other).

### Features

#### New features

* Added `LabMark` class ([#91](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/91))
  * **Description**: Each `Lab` is associated with a `LabMark` which is `Unknown` when `LabStatus` is `UNSUBMITTED`/`SUBMITTED` and an integer from 0 to 100 when `LabStatus` is `GRADED`
  * **Motivation**: Allows TA to keep track of marks given to individual labs when grading labs of students.
  * **Highlights**: Involved multiple defensive checks comparing `LabMark` and `LabStatus` in order to ensure that invalid labs (e.g. `GRADED` labs with `Unknown` marks) did not exist
* Implemented `SubmitLabCommand`, `GradeLabCommand`, `EditLabCommand` ([#91](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/91))
  * **Description**:
    * `SubmitLabCommand` allows for updating of `LabStatus` from `UNSUBMITTED` to `SUBMITTED`
    * `GradeLabCommand` allows for updating of `LabStatus` from `UNSUBMITTED` or `SUBMITTED` to `GRADED` and updates `LabMark` from `Unknown` to a given integer from 0 to 100
    * `EditLabCommand` allows for editing of `LabStatus` and/or `LabMark` (provided that the resultant lab is not invalid, e.g. `LabMark` is not `Unknown` yet `LabStatus` is not `GRADED`)
  * **Motivation**:
    * Allows TA to keep track of students' progress in labs as well as his/her own grading progress.
    * Allows TA to modify previous data which may have been incorrectly entered.
  * **Highlights**:
    * `SubmitLabCommand` and `GradeLabCommand` are subclasses of `EditLabCommand` with an identical `Command#execute` method, which calls other methods that perform validity checks on the labs to be edited and return class-specific error messages. Differing behavior is implemented using the OOP principle of polymorphism by overriding of superclass methods.
    * Originally was `EditLabStatusCommand` ([#71](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/71)), but refactored to three different commands after addition of `LabMark`

#### Enhancements to existing features
* Refactored `Person` from AddressBook Level 3 to `Student`
  * Added `StudentId` attribute ([#50](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/50)), deleted `Phone` and `Address` attributes ([#52](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/52))
  * Renamed class, variable and method names ([#76](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/76))
  * Updated `AddCommand`, `EditCommand` and relevant tests
* Fix bugs from PE-D: [#122](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/122)

### Other contributions

#### Documentation
* User Guide (UG):
  * Added documentation for `labsub`, `labgrad`, `labedit` ([#96](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/96))
  * Added sample screenshots ([#133](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/133))
  * Refined UG by standardizing formatting and parameter constraint descriptions (e.g. for `INDEX` and `LAB_MARK`)
* Developer Guide (DG):
  * Contributed to user stories and use cases UC1, UC3, UC4, UC5 ([#33](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/33), [#85](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/85))
  * Added implementation details for `labedit` ([#143](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/143))
  * Added instructions for manual testing of `labedit`
* Ensured that PDF versions of UG and DG looked and worked as expected

#### Project management
* Managed issue tracker by converting user stories and other features to issues and assigning them to relevant team members
* Helped to manage milestones by adding deadlines and labeling issues

#### Review and mentoring
* Helped to review team members' PRs, e.g. [#67](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/67), [#77](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/77), [#90](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/90)
* Contributed 11 bug reports/suggestions for another team during [PE-D](https://github.com/channne/ped/issues) 

