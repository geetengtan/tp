## Ryan Tan Gee Teng's Project Portfolio Page

### Project: TAddressBook

Below are my contributions to the project:

- **New Feature:** Filter Students by labs [#70](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/70) & [#94](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/94)
    - What it does:
      - Filters the student list by their `labNumber` and `labStatus`. `StudentHasLabPredicate` is utilised to filter
        the `filteredStudentList`.
    - Justification:
      - The TAddressBook might have large amounts of students and the TA will want a more concise list of students
        with specific commonalities.
    - Highlights:
      - This feature involved introducing a `Predicate` in a javafx `FilteredList`.
      - Added functionalities for `LabStatus` to support current features.

- **New Feature:** View Student Details [#90](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/90)
  - What it does:
    - Previews a student's details in another pop up window. Hidden details such as `labMark` are shown here.
  - Justification:
    - TA might want to examine a student's lab performance.
  - Highlights:
    - This feature is UI intensive. The css and fxml of the `ViewWindow` also made use of the `LabLabel` to create a
      better looking list of labs in the `ViewWindow` with dynamic colours.

- **Code Contributed**:
  - Code contributed can be found at this [RepoSense Link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=geetengtan&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18)

- **Enhancements to existing features:**
  - Improved FilterCommand to be able to apply filter in conjunction with previous ones [#94](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/94)
  - Fix bugs from PE-D: [#120](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/120)

- **Documentation**
  - User Guide
    - Added documentation for `ViewCommand`. [#90](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/90)
    - Added documentation for `FilterCommand`. [#94](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/94)
  - Developer Guide
    - Added UC2 [#30](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/30)
    - Added implementation details for `FilterCommand`

- **Community**
  - Reviewed PRs of other group members. [#67](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/67), [#71](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/71)
  - Improved code of other group members to fit functionalities. [#87](https://github.com/AY2122S2-CS2103-F10-1/tp/pull/87)
  - Reported 8 bugs for another group in [PE-D](https://github.com/geetengtan/ped/issues)
