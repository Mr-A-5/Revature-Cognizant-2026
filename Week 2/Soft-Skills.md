# 10 Soft-Skills Questions

## 1. Tell me why did you choose Programming/Software

Growing up, I was always good with math, and honestly, it may be shallow, but I wanted to
follow a career that provided a high salary, like petroleum engineering. This would also
be useful in my home country of Venezuela, even though I did not feel a deep passion for
the field itself.

That completely changed when I took my first Computer Science class in high school. For
the first time, studying was genuinely fun. The way I can make anything, how there is
always more than one way to do it, and how proud one feels after seeing the final product
work. It actually reminded me of building complex mechanisms in Minecraft as a kid, but
without any of the in game limitations. With coding, the possibilities were endless.

Since then, I have taken the time to study in my free time, obtain my degree in Computer
Science, and build small projects on the side to feed my curiosity.

Now, I am here in front of you, excited for the opportunity to keep learning and building
real world applications.

## 2. Tell me about a Project you worked on in the past and what technologies you used?

When I arrived in the US 7 years ago, I needed to help my parents get their driver
licenses. One of the steps was an online 6 hour driving course to waive the written test.
I got them the link and helped them set up their accounts. Because they had a good
experience with that site, they always ask me to send them the link again for their
friends and family who also need help with the process. I found out the course is
privately owned, so I decided to create my own and go through the application process.

The goal was to make a TDLR (Texas Department of Licensing and Regulation) approved course
that had the basic functionality to store user information, keep user data secure, teach
content, enforce learning, and provide certification at the end.

The first step was extensive research in order to get all the requirements from the TDLR.
The department had guidelines to be followed regarding time per content, validation of the
users, time tracking, and data collection, but this content was scattered throughout
different forms, sites, and applications. After gathering all the requirements, I moved to
design the schemas, basic pages, endpoints, and technologies that would be required. I
used Next.js to design the frontend and backend, Clerk for authentication, Stripe for
payments, and Supabase as the database. The frontend uses React, and both the frontend and
backend use TypeScript as the programming language. I implemented the blueprints
successfully and tested the flow in development and production. Moreover, I had my parents
act as users to test that the flow was easy to understand and similar to the course they
had already done.

The final product was an online driving platform that recently got approved by the TDLR to
start teaching adults the guidelines of driving in Texas.

## 3. Explain to me the process you follow when you need to learn a new technology?

Whenever I have had to learn a new technology, it has usually been at the start of a new
project, such as during my UTD Senior Project class. In this case, we were given
documentation during the first week of class regarding the technologies we were going to
be using, such as Clerk, Supabase, and Express.js.

Initially, I would only work in the backend, connecting the frontend and Supabase by
creating secure, Clerk-authenticated endpoints. Thus, my job those first few weeks was to
learn how these technologies fit together.

The method I usually follow is looking at YouTube video tutorials first. I research each
technology individually. The goal is to learn more about what they do, why we use them,
and where. From there, I move into looking for information regarding how they are
implemented together. I look for information such as, "How is Clerk used in Express.js?".
I try to take notes as much as possible, and if possible, follow the examples by creating
my own repositories. I will also read the documentation specific to implementation. For
example, Clerk and Supabase both have detailed documentation on how to link them. By this
point, I usually have a good idea of how everything works, and I can start working on the
project.

Using these methods, I have built a strong foundation in Clerk, Supabase, Express, and
TypeScript, to a point where I still use them when they fit for the development of
personal projects.

## 4. How do you collaborate with team members while working on a big project?

During my Senior Project at UTD, collaboration was done mostly through GitHub workflows
and Slack communication.

Our task was to create a dashboard for the client to fetch and manage Google Reviews, and
we used the Scrum framework and Agile development, switching roles during development in
order for all of us to get equal experience with various technologies.

We had meetings with the client and the other team members every Friday. I would always
speak with the other members in order to get an idea of what we would be working on during
the sprint, and how they wanted to split the work based on our skills. I always attempted
to set up at least one day to meet virtually or in person to get some work done at the
same time. The main idea of this collaboration time was to speak about blockers, get an
idea of how our work would affect each other, and match the coding guidelines we were
following. Moreover, we could discuss branching and committing our changes. If we had any
further questions, we could always communicate through Slack.

We were able to finish all our goals for the semester and deploy a working version of the
dashboard.

## 5. How do you handle receiving critical feedback on your code?

As a beginner developer, receiving critical feedback is a common occurrence. I have been
blessed with nice and comprehensive mentors up to this point. Whenever I was told I did
something wrong, I always asked the same questions: "What could I have done differently?",
"Could you provide any documentation or articles on this?", and "How is this done in the
real world?".

From their answers, I usually got a good starting point to educate myself on how to
achieve an efficient solution. I often get stuck during development wondering, "How is
this actually done by professional developers?", so getting answers to these questions
from mentors is always a great experience. The experience I have today is because of the
positive and negative feedback I have received

## 6. Where do you see yourself in five years?

Right now, honestly, I feel like I am at the bottom of a staircase I am still figuring out
how to climb. Most roles I am applying to want experience I do not have yet, or fluency
with enterprise level tools I have only touched in practice.

In five years, I want to be past that and become someone with real production experience,
who knows how to work effectively on a team, and who writes code that is sustainable,
readable, and scalable. I want to reach a point where I can build in a month what used to
take me four, but 10 times better. Furthermore, I eventually want to become someone newer
developers can lean on, the way I am hoping to lean on more senior engineers now.

Every day, I try to learn more about current hot technologies while also researching
enterprise level tools. I attempt to keep track of new models, agents, and methods that
help with coding. On the other hand, I try to use my free time to reinforce the basics of
coding, ensuring that I have those soft skills recruiters look for.

I hope these daily efforts will help me transform into that future experienced version of
myself.

## 7. Tell me about a big bug or issue you came across and how you solved it?

On the driving course platform I developed, I had to ensure the student spent a certain
amount of time, 1 second per every 3 words of material shown to them, which I found
difficult to implement across the frontend, backend, and database.

My first solution while developing the page was a frontend state variable with a timer for
enforcing the minimum time per slide. This method did not prevent a user with basic
programming knowledge from changing the variable to skip the timer. Rather than treating
that as a failure, I used it to rethink the design from the ground up, moving the source
of truth to the backend.

I added a backend check when the slide was opened to ensure the time the slide was started
and how long it should take were enforced. This ensured that even if the state variable
disabling the "next" button was manipulated, the button would not actually work unless the
backend confirmed enough time had passed. Later, I noticed another requirement: time could
only continue whenever the user had the tab actively open. It took two more iterations
adding the wait-time table, then the active-tab heartbeat before it actually satisfied the
requirement end-to-end.

The lesson for me was to question my own assumptions about what a user could and could not
manipulate, especially anything running purely in the browser.

## 8. Describe a time you disagreed with a teammate. How did you handle it?

During the frontend work on the capstone project for UTD, my teammate and I were
implementing a wireframe for what I believe was the dashboard. One design called for a
checkbox that turned light blue when checked, but we were using a component library (I
believe it was Flowbite) that did not allow us to change that specific section of the
component, the inside would turn black when checked. Our specific role was implementing
these wireframes, so it was a big issue for us not being able to achieve it perfectly.

Our engineering advisor had previously told us not to reinvent the wheel and to stick with
Flowbite components wherever possible, so I suggested we leave the color as it was and
raise it with the client during our next meeting to confirm it was an acceptable change.
My teammate disagreed and thought we should build a custom checkbox component instead. We
couldn't reach an agreement, so we set up a call with the engineer before the sprint
meeting. He said both approaches were reasonable, but recommended sticking with Flowbite
for consistency and reliability, and then checking with the client.

We checked with the client, and they allowed the change. From this experience, I learned
that it is always better to bring in a third party when in a disagreement, and that not
all designs are final and can be subject to change.

## 9. What are your biggest strengths and weaknesses?

One thing that is both a strength and a weakness for me is that I tend to take on too much
by myself before asking for help.

During the capstone project for UTD, early on, we were supposed to implement secure
endpoints using Clerk's authentication methods, and I could not get it working no matter
what I tried. I tried researching on YouTube, reading the documentation, and using AI
tools, but solutions would either not match the required specs or just flat-out not work.

We only had a few meetings scheduled at that point, so I had about three days until the
next one with our advising engineer. I assumed that since he'd asked us to implement it,
it had to be possible, so I kept trying on my own the whole time instead of flagging it.
When we finally met, before I even got to explain where I was stuck, he told us upfront
that the implementation was not actually compatible with our current setup, and that he
would send over updated docs with the correct auth flow. In hindsight, if I had raised the
blocker even a day earlier, he could have told me he was already working on it and saved
me most of those three days.

That experience taught me not to sit on a blocker just because I feel like I should be
able to figure it out myself; now, I try to flag it early rather than waiting until the
next scheduled check-in if possible.

## 10. How do you prioritize tasks when you have multiple deadlines?

My approach is to spend roughly the first hour on any new assignment just scoping it out.
I work on it enough to get a rough sense of its complexity and how long it will actually
take.

During the capstone project, whenever we picked up tickets for a sprint, my partner and I
would first agree on how to split the work, then I'd research my share briefly and take
notes on what I'd need to do before actually sitting down to build it. I use the same
approach for coursework.

From there, I tackle the more complex tasks first, since they usually take the most time.
If I make solid progress on something and then hit a small blocker, I will switch to
another task rather than do nothing for a few hours. This method keeps me moving forward
and gives me a better sense of how much time is really left for everything else.

Using this method, I was able to finish almost all tickets on time during my Senior
Project class.
