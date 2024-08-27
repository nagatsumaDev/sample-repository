$(function(){
	let tabs = $(".menu");
    $(".menu").on("click", function() {
        $(".active").removeClass("active");
        $(this).addClass("active");
        const index = tabs.index(this);
        $(".content").removeClass("show").eq(index).addClass("show");
    });
});
