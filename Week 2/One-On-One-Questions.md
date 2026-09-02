# Self One on One Questions Answers:

## What the step of SDLC?

The software development cycle has 3 main phases with 2 to 3 sub-phases per main phase. In
order, the phases are: Design, which sub-phases are Requirement Gathering, Requirement
Analyzing, Design; Development which sub-phases are Develop, Testing, and user-acceptance
testing; Delivery which sub-phases are Release and Maintenance.

## How is the waterfall methodology distinct from agile?

Waterfall is a strict, sequential process where you design, build, and test the entire
project once, delivering it only at the very end. Agile is an iterative approach where you
break the work into small cycles. During each cycle you build, test, and deliver
functional pieces of software which allow receiving feedback and adding changes for future
cycles if needed.

## What is zero-shot prompting?

It is the practice of relying entirely on the model's pre-training knowledge, thus asking
it to perform a task without providing examples. An example of this is using a llm to
extract the sentiment of a chunk of text. For example, writing something like "Here is
this piece of text, label it into either positive, neutral, or negative", by not providing
any example, you rely on the models knowledge to label the text correctly. This is faster
than providing detailed examples of what you consider positive or negative, but at the
same time it may label text with less accuracy to your specific use case.

## What is the purpose of git branches and pull requests? (please also describe the CLI commands to create/push to a repo)

Git branches allow developers to safely build and test new features in an isolated
environment without disrupting the main source code. Once that work is complete, a pull
request serves as a proposal to merge those branched changes back into the primary
codebase. This workflow facilitates collaboration by giving team members a dedicated space
to review, discuss, and approve new code before it goes live. Some CLI commands used for
this are: git init to initialize a git repository, git add . to stage all files or git add
filename for specific files. git commit -m along with a message describing the changes
made. git remote add origin and the url of the repository in github to connect to it, and
finally git push -u origin main to push those changes into github for everyone to see.
