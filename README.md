# CustomFragmentStatePagerAdapter

Once while using FragmentStatePagerAdapter I came accross a problem or one can even say a bug which I would like to share. When we load a page, remove it and then insert a new one in its place, the next time the fragment at that index is loaded, it recieves the savedInstanceState bundle for the old fragment.

The specific case where I discovered this was while making a quiz app. I was storing the question tag as label and the question text was coming from the adapter. In the case when we change the content of the adapter, question is changed as it is now a different fragment but the question tag remains the same, as it gets restored from the previous fragments saved state. If we rotate our device, or simply swipe back and then come back to that fragment position we see the correct tag of question (as it saves the state fresh when it removes it, resulting in the correct saved state next time it’s loaded).

Inorder to resolve and show this issue I have made a CustomFragmentStatePageradapter.
