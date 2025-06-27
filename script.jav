// Smooth Scrolling for Navigation
document.querySelectorAll('nav ul li a').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });

        // Close mobile menu if open
        if (navbarMenu.classList.contains('active')) {
            navbarMenu.classList.remove('active');
            hamburger.classList.remove('active');
        }
    });
});

// Mobile Navigation Toggle
const hamburger = document.querySelector('.hamburger');
const navbarMenu = document.querySelector('nav ul');

hamburger.addEventListener('click', () => {
    navbarMenu.classList.toggle('active');
    hamburger.classList.toggle('active');
});

// Add shadow to header on scroll (optional, but nice touch)
const header = document.querySelector('header');
window.addEventListener('scroll', () => {
    if (window.scrollY > 50) {
        header.style.boxShadow = '0 4px 10px rgba(0, 0, 0, 0.15)';
    } else {
        header.style.boxShadow = 'var(--box-shadow)';
    }
});

// Simple fade-in effect for sections on scroll (using Intersection Observer API)
const sections = document.querySelectorAll('section');

const observerOptions = {
    root: null,
    rootMargin: '0px',
    threshold: 0.1
};

const sectionObserver = new IntersectionObserver((entries, observer) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = '1';
            entry.target.style.transform = 'translateY(0)';
            observer.unobserve(entry.target); // Stop observing once it's visible
        }
    });
}, observerOptions);

sections.forEach(section => {
    section.style.opacity = '0';
    section.style.transform = 'translateY(20px)';
    section.style.transition = 'opacity 0.6s ease-out, transform 0.6s ease-out';
    sectionObserver.observe(section);
});