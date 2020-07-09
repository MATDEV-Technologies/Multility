# Multility
Multiple utilities in one. A summer project. Android is the main and original platform of distribution.</br></br>Please make sure to read **all** of the README if first joining.</br></br>**SPECIFIC TO THE "working" BRANCH**: For any comments that are prefixed by "**DO NOT REMOVE**" or "**DO NOT DELETE**," please **DO NOT** remove them since they contain either postponed content, temporary fallback code, or really important documentation. In general to be safe, keep all comments and document your code to help others understand.</br>

## Extra project resources
 - [Discord Server](https://discord.gg/nSKwHYR)
 - [Ideas document](https://docs.google.com/document/d/1ZJ-9lwCcr5kKQ4zTAPAAQd2noOBvZBnx5S1e-p9YDfU/edit?usp=sharing)
 - Initial tool setup series</br>
   - [Git](https://bit.ly/3fTqoXO)
   - GitHub (You are on it, but if you need the doc again, it is [here](https://docs.google.com/document/d/1jfR-Fynh5D13MhGe48SEheDDyGM_rwKsX_gsuu6Sck4/edit?usp=sharing)), SET UP SSH CLONING (cannot easily clone private repos without it): https://bit.ly/2ZaJFhX
   - [Android Studio](https://bit.ly/3i34ao6)
 - Social Media:</br>
   - Email: *matdevtechstudios@gmail.com* (hyperlinked as "mailto")
   - [Facebook](https://www.facebook.com/Matdev-Technologies-111656083937882): *@Matdev-Technologies* (currently disabled)
   - [Twitter](https://twitter.com/MATDEVtech): @MATDEVtech
   - [Instagram](https://www.instagram.com/matdevtechnologies/): *@matdevtechnologies*
   - [Linkedin](https://www.linkedin.com/in/matdev-technologies-9a08411aa/): *@matdev-technologies*
   - GitHub (Basically here but just one page directory back)</br></br>
 - [Floobits workspace](https://floobits.com/MichaelSDavid/Multility/) (collaborative real-time coding) (DO NOT SHARE OUTSIDE THE DEV TEAM)

## Project specifications and workflow
 - **Android Studio Metadata**:</br>
   - **Application name**: Multility
   - **Package name**: com.matdevtech.multility
   - **Language**: Java (Kotlin may be added later if fit for the project and still allows future porting)
   - **Project JDK**: ADS Embedded JDK - JDK v1.8.0_251 (Java 8)
   - **Main API/OS**: Mix of 29 (Q) / 30 (R)
   - **Main AVD**: Mix of Pixel 3a XL / Pixel 3 XL and API 29 / API 30
   - **Gradle version**: 6.1.1 (specifically gradle-6.1.1-all in the wrapper properties) (or use "gradlew/gradlew.bat" provided) (do *NOT* upgrade Gradle as of now)
   - **Minimum SDK**: API 19 - Android 4.4 (KitKat) (recommended in 2020)
   - **Template**: Empty Activity
   - **Use legacy android.support libraries**: OFF</br>
   (JUnit now upgraded to version 4.13)

 - **GitHub Tab**s:</br>
   - **Code tab**: Where the files and code can be viewed, edited, cloned, and the repository details are visible
   - **Issues tab**: This is for reporting issues or bugs that are relatively major or just hard to fix so that multiple members can some together and find a solution, as well as feature ideas/requests
   - **Pull Requests tab**: This is where you can make a proposal for new code in the project to be merged with either the master or working branch. Always discuss and make corrections (if needed) before actually confirming the request and adding it to the given branch
   - **Actions tab**: This is for Continuous Integration with GitHub actions that performs tests and checks before allowing certain actions to happen on the repository. This project uses GitHub's built in "Android CI" Actions template which runs some Gradle tests and checks on pushes as well as pull requests to both the master and working branch
   - **Projects tab**: Where the project has its planning, tasks to do, and track of progress/status (uses the Automated Kanban template)
   - **Security tab**: Security vulnerabilities and actions are all there; usually GitHub finds and reports them on their own and no manual checking has to be done (waiting to get some private beta access to more advanced features as of now)
   - **Insights tab**: Various statistics about activity, progress, collaboration, participation, and dependency tracking (currently disabled since you need Pro to view this on private repositories, and you can't get it for free as a student on an organization, like a normal account)
   - **Settings**: Global settings about the repository
 
 - **General development things**:</br>
   - Please watch this (or any other resources on the Git/GitHub install doc) to catch up and make sure you know how to work with these tools, otherwise development will be very complicated and you won't be able to contribute as much you really could be able to: https://youtu.be/DVRQoVRzMIY (also terminology: https://bit.ly/38Acuao)
   - Not as important, but GitHub Actions is a form of CI or Continous Integration that is used here. If you want to be more clear on how it works read [here](https://searchsoftwarequality.techtarget.com/definition/continuous-integration) and [here](https://github.com/features/actions), 
   - Starting out, if you don't have the project, switch to the "working" branch and click the "Code" button and then clone using SSH (CMD for cloning the "working" branch with SSH: `git clone --branch working git@github.com:MATDEV-Technologies/Multility.git`) (only if there are no current issues or test fails (red "X" next to the latest commit) plaguing the repo or that specific branch, otherwise, discuss what can someone new clone (the "master" branch as the default if changes need to be removed since they caused certain issues)
   - Always make changes on the "working" branch if you aren't sure; only commit to the master branch for super general and stable code
   - The general gist is that you will commit and push to the "working" branch and then make a pull request from your recent commit to discuss and prepare for merging with the "master" branch. This is the most secure (Check below in the commit workflow image for more details)
   - There is technically no need to back up your files, unless the Android CI checks are negative (red "X" next to the latest commit), then you can back up your current local copy of the project and either pull or clone the repository from the latest commit in the given branch and fix the errors, then re-commit and push
   - If pull requests need to be expanded more, there is a bug to bring attention to and work to solve, or there is a feature request, make sure to use the Issues tab and appropriate tags, along with some new templates
   - We will be following the general SDLC, and we are as of now roughly in the Design and Implementation stage (and I guess also testing occasionaly) (refer to the SDLC overview image for reference)
   - You can most optimally contibute on your own time on different goals and parts of the application, or if available, collaborate in real time in voice chat and using [Floobits](https://floobits.com/) (Android Studio setting up the same as the IntelliJ guide) (make sure to not share workspace links or profiles since this is private code, but no one wants to pay for Pro to get private workspaces)
   - *PLEASE* always check for successful commits in your branch (should mainly be the "working" branch) and pull or clone to make sure everyone has the same codebase (not really necessary for commits that only update the README tho)
   
 - **SDLC Overview**:</br>
 !["SDLC_image.jpg"](https://cdn.discordapp.com/attachments/342481673822404608/726630374561546270/SDLC-stages.png)</br></br>
 
 - **Commit Workflow**:</br>
 !["workflow_gh.jpg"](https://cdn.discordapp.com/attachments/342481673822404608/726630332136423434/github_commit_flow.png)</br></br>
 
 (Social image URL: bit.ly/3dOuRtm (disabled for being a private repo))
