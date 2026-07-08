# Katalon Mobile Visual Automation Framework

Mobile automation testing framework using Katalon Studio, Appium, Groovy, and OpenCV.

This project demonstrates mobile QA automation implementation including functional testing, UI validation, custom reusable keywords, and visual regression testing using image comparison.

## Tech Stack

- Katalon Studio
- Appium
- Groovy
- Android UIAutomator
- OpenCV Image Processing
- Git / GitHub

---

## Features

### Mobile Functional Automation
- Automated mobile UI interaction
- Element validation
- Text verification
- Location search validation
- Tooltip validation
- Negative scenario testing

### Visual Regression Testing
- Baseline image comparison
- Element screenshot capture
- Pixel difference detection
- Match percentage calculation
- Auto generate actual image
- Generate diff image when mismatch detected

---

## Test Scenarios

| Test Case | Scenario | Validation |
|---------|----------|------------|
| TC-01 | Verify Rent Home Default State And Greeting | UI element validation, text assertion |
| TC-03 | Verify Auto-fill Location Logic (GPS Outside Coverage) | Location behavior validation |
| TC-04 | Verify Operational Area Tooltip Functionality | Tooltip UI validation |
| TC-07 | Verify Search Location Empty State (No Result) | Text validation + OpenCV visual comparison |

---

## Framework Structure

```
Katalon-Mobile-Visual-Framework

├── Test Cases
│   └── Mobile Visual Regression Testing
│
├── Object Repository
│   └── Mobile Objects
│
├── Keywords
│   └── helper
│       ├── ImageHelper.groovy
│       ├── ScreenshotHelper.groovy
│       ├── TextHelper.groovy
│       └── VerifyHelper.groovy
│
├── BaselineImages
│
├── ActualImages
│
└── DiffImages
```

---

## Custom Keyword Implementation

### ImageHelper

Responsible for visual validation using OpenCV.

Capabilities:

- Capture mobile element screenshot
- Compare baseline and actual image
- Calculate image similarity percentage
- Generate difference image


Example result:

```
IMAGE DIFFERENCE : 0.0%
IMAGE MATCH : 100.0%
Test Result : PASSED
```

---

## Visual Regression Evidence

Example execution result from mobile visual regression testing.

The automation captures UI elements directly from the Android application and compares them with baseline images using OpenCV pixel comparison.

### Visual Match Result (PASSED)

Actual image matches with baseline image.

https://drive.google.com/file/d/18J9kJpQHYDHfIpr1qpYoiX2f-wqoHcJz/view?usp=sharing

Result:

```text
IMAGE DIFFERENCE : 0.0%
IMAGE MATCH : 100.0%
Test Result : PASSED
```

---

### Visual Difference Detection

Example when UI differences are detected.

OpenCV detects pixel changes between baseline and actual screenshots.

https://drive.google.com/file/d/17e1NIDc8wLMtvirax-2g1xaAJLewwLNs/view?usp=sharing

Result:

```text
IMAGE DIFFERENCE : 0.918507347%
IMAGE MATCH : 99.081492653%
Diff image generated for analysis
```

---

## Visual Testing Flow


1. Capture element from mobile application

2. Compare with baseline image

3. Calculate pixel difference

4. Generate result

```
Baseline Image
      |
      v
Actual Screenshot
      |
      v
OpenCV Comparison
      |
      v
PASS / FAIL
```

---

## Test Result Example

PASSED:

```
TC-01 Functional Validation Passed

TC-03 Location Logic Passed

TC-04 Tooltip Validation Passed

TC-07 Visual Regression Passed

IMAGE MATCH : 100%
```

---

## Purpose

This project was created as a QA Automation portfolio demonstrating:

- Mobile automation framework design
- Reusable keyword architecture
- Functional regression testing
- Visual regression testing implementation
- Real QA engineering workflow

---

## Author

Septian Pratama  
QA Engineer
